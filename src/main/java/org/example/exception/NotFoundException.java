package org.example.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {

    protected final Code code;

    protected NotFoundException(Code code, Throwable e, String msg) {
        super(msg, e);
        this.code = code;
    }

    @Getter
    public enum Code {

        PASTE_NOT_FOUND("error_message.paste_not_found"),
        RECORD_NOT_FOUND("error_message.record_not_found"),
        ;

        private final String userMessageProperty;

        Code(String userMessageProperty) {
            this.userMessageProperty = userMessageProperty;
        }

        public NotFoundException get(String msg) {
            return new NotFoundException(this, null, msg);
        }
    }
}
