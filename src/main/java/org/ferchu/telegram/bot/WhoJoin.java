package org.ferchu.telegram.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class WhoJoin extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Attendance bot, working on it.";
    }

    @Override
    public String getBotToken() {
        return "1982309467:AAEmzlI2dQmP1OlaKzroM8UGsZ7QUTPnVQk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        final String messageTextReceived = update.getMessage().getText();
        System.out.println("Hello we are inside the bot!!!");
        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();

        // Se crea un objeto mensaje
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(messageTextReceived + "holaa");
        try {
            // Se envía el mensaje

            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
