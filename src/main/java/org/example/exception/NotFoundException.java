package org.example.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {

    protected final Code code;

    protected NotFoundException(Code code, String msg, Throwable e) {
        super(msg, e);
        this.code = code;
    }

    @Getter
    public enum Code {
        PASTE_NOT_FOUND("#"),
        ;

        private final String userMessageProperty;

        Code(String userMessageProperty) {
            this.userMessageProperty = userMessageProperty;
        }
    }
}
