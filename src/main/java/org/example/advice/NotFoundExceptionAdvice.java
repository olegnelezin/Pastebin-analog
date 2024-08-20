package org.example.advice;

import org.example.dto.ErrorMessage;
import org.example.exception.NotFoundException;
import org.example.util.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class NotFoundExceptionAdvice extends BaseControllerAdvice {

    public NotFoundExceptionAdvice(MessageHelper messageHelper) {
        super(messageHelper);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorMessage> handleException(NotFoundException e) {
        var status = switch(e.getCode()) {
            case PASTE_NOT_FOUND -> HttpStatus.NOT_FOUND;
        };

        var code = e.getCode().toString();
        var userMessageProperty = e.getCode().getUserMessageProperty();
        return formErrorMessage(e, status, code, userMessageProperty);
    }
}
