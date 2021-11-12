package org.ferchu.telegram.bot.commands;

import org.ferchu.telegram.bot.WhoJoin;
import org.ferchu.telegram.bot.utils.preferences.PrefObj;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component("help")
public class HelpCommand extends Command {
    @Override
    public void botReply(Update update, WhoJoin bot, PrefObj prefs) throws TelegramApiException {

    }
}
