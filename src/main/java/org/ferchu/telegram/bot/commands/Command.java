package org.ferchu.telegram.bot.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ferchu.telegram.bot.WhoJoin;
import org.ferchu.telegram.bot.utils.preferences.PrefObj;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Command {

    private String alias;

    public abstract void botReply(Update update, WhoJoin bot, PrefObj prefs) throws TelegramApiException;
}