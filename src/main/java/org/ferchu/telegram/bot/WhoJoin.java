package org.ferchu.telegram.bot;

import org.ferchu.telegram.bot.commands.Command;
import org.ferchu.telegram.bot.commands.NotFoundCommand;
import org.ferchu.telegram.bot.configuration.ActivesCommandsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.ExecutionException;

@Component
public class WhoJoin extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(WhoJoin.class);

    @Value("${bot.token}")
    String token;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ActivesCommandsConfiguration commands;

    @Override
    public String getBotUsername() {
        return "Attendance bot, working on it.";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) throws RuntimeException {
        final String messageTextReceived = update.getMessage().getText();
        System.out.println("Hello we are inside the bot!!!");
        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();
        final long userId = update.getMessage().getFrom().getId();

        Command commandt = getSentCommand(update);
        try {
            commandt.botReply(update, this, null);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        if (isAdmin(String.valueOf(userId), String.valueOf(chatId))) {


        } else {

            Command command = getSentCommand(update);
        }

//        if(messageTextReceived.equals("poll") || messageTextReceived.equals("Poll")) {
//
//            SendPoll poll = new SendPoll();
//            poll.setChatId(String.valueOf(chatId));
//            poll.setQuestion("¿Eres gilipollas?");
//            List<String> options = new ArrayList<>();
//            options.add("Sí");
//            options.add("Sí");
//            poll.setOptions(options);
//
//            try {
//                // Se envía el mensaje
//
//                execute(poll);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            // Se crea un objeto mensaje
//            SendMessage message = new SendMessage();
//            message.setChatId(String.valueOf(chatId));
//            message.setText(messageTextReceived + " putazorra");
//            try {
//                // Se envía el mensaje
//
//                execute(message);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public boolean isAdmin(String userID, String chatID) {
        boolean result = false;
        if (!userID.equals(chatID)) {
            try {
                GetChatMember getChatMember = new GetChatMember();
                getChatMember.setChatId(chatID);
                getChatMember.setUserId(Long.valueOf(userID));
                ChatMember chatMember = execute(getChatMember);

                result = chatMember.getStatus().equals("creator") || chatMember.getStatus().equals("administrator");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return result;
    }

    public int sendMessageAsyncBase(SendMessage sendMessage, Update update) {
        /*
         * Execute executeAsync() method & use existent SendMessage object
         */
        try {
            return executeAsync(sendMessage).get().getMessageId();
        } catch (TelegramApiException | ExecutionException | InterruptedException exception) {
            logger.error(exception.getMessage() + " (CID: " + update.getMessage().getChat().getId() + " | UID: " + update.getMessage().getFrom().getId() + ")");
        }
        return 0;
    }

    private Command getSentCommand(Update update) throws RuntimeException {

        Command command = null;
        String message = update.getMessage().getText();
        if (message.startsWith("/")) {
            String commandStr = message.split("/")[1];
            if (commandStr.contains("@")) {

                commandStr = commandStr.split("@")[0];
            }
            if (commands.getCommands().contains(commandStr)) {

                command = applicationContext.getBean(commandStr, Command.class);
            } else {

                command = new NotFoundCommand();
            }
        } else {

            //TODO return unknown command exception
            throw new RuntimeException("");
        }
        return command;
    }

    public void sendTextMessage(String messageStr, String chatId) throws TelegramApiException {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(messageStr);
        execute(message);
    }
}
