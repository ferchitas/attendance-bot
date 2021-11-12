package org.ferchu.telegram.bot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.ferchu.telegram.bot.WhoJoin;
import org.ferchu.telegram.bot.exceptions.NoAdminException;
import org.ferchu.telegram.bot.utils.constants.InternalConstants;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Aspect
@Component
public class IsAdminAspect {

    @Before("execution(* org.ferchu.telegram.bot.commands.CreateListCommand.botReply(..))")
    public void isAdmin(JoinPoint joinPoint) throws Exception {

        Update update = (Update) joinPoint.getArgs()[0];
        WhoJoin bot = (WhoJoin) joinPoint.getArgs()[1];
        String chatId = String.valueOf(update.getMessage().getChatId());
        String userId = String.valueOf(update.getMessage().getFrom().getId());
        if (!userId.equals(chatId)) {
                GetChatMember getChatMember = new GetChatMember();
                getChatMember.setChatId(chatId);
                getChatMember.setUserId(Long.valueOf(userId));
                ChatMember chatMember = bot.execute(getChatMember);
               if(!(chatMember.getStatus().equals("creator") || chatMember.getStatus().equals("administrator"))) {

                    bot.sendTextMessage(InternalConstants.NO_ADMIN_USER, chatId);
                    throw new NoAdminException(InternalConstants.NO_ADMIN_USER);
               }
        }
        else throw new TelegramApiException("");
    }
}
