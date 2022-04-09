package org.ferchu.telegram.bot.configuration;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;
import org.ferchu.telegram.bot.WhoJoin;
import org.ferchu.telegram.bot.graphql.AttendeeDataFecher;
import org.ferchu.telegram.bot.graphql.AttendeesDataFecher;
import org.ferchu.telegram.bot.repository.IAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@org.springframework.context.annotation.Configuration
public class BeanConfiguration {
    
    private GraphQL graphQL;

    @Autowired
    private IAttendeeRepository attendeeRepository;
    @Autowired
    private AttendeeDataFecher attendeeDataFecher;
    @Autowired
    private AttendeesDataFecher attendeesDataFecher;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("attendees", attendeesDataFecher)
                        .dataFetcher("attende", attendeeDataFecher))
                .build();
    }

    @Bean
    public TelegramBotsApi telegramBotsApi(@Autowired WhoJoin whoJoin) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(whoJoin);
        return telegramBotsApi;
    }

    @Bean
    public static JaegerTracer getTracer() {
        Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1);
        Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
        Configuration config = new Configuration("jaeger test").withSampler(samplerConfig).withReporter(reporterConfig);
        return config.getTracer();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
