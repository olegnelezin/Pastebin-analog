package org.example.exception;

import lombok.Getter;

@Getter
public class MinioException extends BaseException {

    protected final Code code;

    protected MinioException(Code code, Throwable e, String msg) {
        super(msg, e);
        this.code = code;
    }

    @Getter
    public enum Code {
        CREATE_BUCKET("#"),
        UPLOAD_TEXT("#")
        ;

        private final String userMessageProperty;

        Code(String userMessageProperty) {
            this.userMessageProperty = userMessageProperty;
        }
    }
}
