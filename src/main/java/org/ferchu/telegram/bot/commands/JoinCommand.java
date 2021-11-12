package org.ferchu.telegram.bot.commands;

import org.checkerframework.checker.units.qual.C;
import org.ferchu.telegram.bot.WhoJoin;
import org.ferchu.telegram.bot.utils.constants.InternalConstants;
import org.ferchu.telegram.bot.utils.preferences.PrefObj;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component("join")
public class JoinCommand extends Command {
    @Override
    public void botReply(Update update, WhoJoin bot, PrefObj prefs) throws TelegramApiException {

        long chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(InternalConstants.JOINING_TO_A_LIST);
        bot.execute(message);
    }
}
