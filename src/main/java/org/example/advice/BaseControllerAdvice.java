package org.example.advice;

import lombok.AllArgsConstructor;
import org.example.dto.ErrorMessage;
import org.example.exception.BaseException;
import org.example.util.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class BaseControllerAdvice {

    private final MessageHelper messageHelper;

    protected ResponseEntity<ErrorMessage> formErrorMessage(BaseException exception, HttpStatus status,
                                                            String code, String userMessageProperty) {
        var userMessage = messageHelper.getMessage(userMessageProperty);
        if (userMessage != null && exception.getMessageParam() != null) {
            userMessage = userMessage.formatted(exception.getMessageParam());
        }
        var devMessage = exception.getMessage();
        var args = exception.getArgs();
        var errorMessage = ErrorMessage.builder()
                .args(args)
                .userMessage(userMessage)
                .devMessage(devMessage)
                .code(code)
                .build();

        return ResponseEntity.status(status).body(errorMessage);
    }
}
