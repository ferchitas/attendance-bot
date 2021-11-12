package org.ferchu.telegram.bot.exceptions;

import org.ferchu.telegram.bot.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> manageException(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), HttpStatus.INTERNAL_SERVER_ERROR.toString());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
