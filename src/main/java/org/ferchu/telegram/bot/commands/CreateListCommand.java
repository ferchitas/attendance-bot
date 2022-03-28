package org.ferchu.telegram.bot.commands;

import org.ferchu.telegram.bot.WhoJoin;
import org.ferchu.telegram.bot.services.AttendanceListService;
import org.ferchu.telegram.bot.utils.constants.InternalConstants;
import org.ferchu.telegram.bot.utils.preferences.PrefObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component("createlist")
public class CreateListCommand extends Command {

    @Autowired
    AttendanceListService attendanceListService;

    @Override
    public void botReply(Update update, WhoJoin bot, PrefObj prefs) throws TelegramApiException {

//        attendanceListService.save();
        long chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(InternalConstants.COMMAND_CREATING_LIST);
        bot.execute(message);
    }
}
