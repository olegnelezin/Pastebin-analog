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

        CREATE_BUCKET("error_message.create_bucket"),
        UPLOAD_TEXT("error_message.upload_text"),
        GET_TEXT("error_message.get_text"),
        ;

        private final String userMessageProperty;

        Code(String userMessageProperty) {
            this.userMessageProperty = userMessageProperty;
        }

        public MinioException get(String msg) {
            return new MinioException(this, null, msg);
        }
    }
}
