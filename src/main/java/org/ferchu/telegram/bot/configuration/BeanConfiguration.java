package org.ferchu.telegram.bot.configuration;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;
import org.ferchu.telegram.bot.WhoJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@org.springframework.context.annotation.Configuration
public class BeanConfiguration {

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
}
