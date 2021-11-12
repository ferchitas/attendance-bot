package org.ferchu.telegram.bot.exceptions;

public class NoAdminException extends RuntimeException {

    public NoAdminException(String errorMessage) {
        super(errorMessage);
    }
}