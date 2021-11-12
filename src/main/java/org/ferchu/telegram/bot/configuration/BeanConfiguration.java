package org.ferchu.telegram.bot.configuration;

import org.ferchu.telegram.bot.WhoJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BeanConfiguration {

    @Bean
    public TelegramBotsApi telegramBotsApi(@Autowired WhoJoin whoJoin) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(whoJoin);
        return telegramBotsApi;
    }
}
