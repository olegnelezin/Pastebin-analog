package org.example.advice;

import org.example.dto.ErrorMessage;
import org.example.exception.MinioException;
import org.example.util.MessageHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MinioExceptionAdvice extends BaseControllerAdvice {

    public MinioExceptionAdvice(MessageHelper messageHelper) {
        super(messageHelper);
    }

    @ExceptionHandler(MinioException.class)
    ResponseEntity<ErrorMessage> handleException(MinioException e) {
        var status = switch (e.getCode()) {
            case CREATE_BUCKET,
                    UPLOAD_TEXT  -> HttpStatus.INTERNAL_SERVER_ERROR;
        };

        var code = e.getCode().toString();
        var userMessageProperty = e.getCode().getUserMessageProperty();
        return formErrorMessage(e, status, code, userMessageProperty);
    }
}
