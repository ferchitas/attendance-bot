package org.ferchu.telegram.bot.exceptions;

public class NotFoundObjectInDatabaseException extends RuntimeException {

    public NotFoundObjectInDatabaseException(String errorMessage) {
        super(errorMessage);
    }
}
