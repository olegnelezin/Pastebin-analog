package org.example.exception;

import lombok.Getter;

import java.util.Map;


public class BaseException extends RuntimeException {

    protected Map<String, Object> args;

    protected String messageParam;

    protected BaseException(String msg, Throwable e) {
        super(msg, e);
    }

    public BaseException messageParam(String messageParam) {
        this.messageParam = messageParam;
        return this;
    }

    public String getArgsAsString() {
        if (this.args == null) {
            return "";
        }

        return args.toString();
    }

    public String getMessageParam() {
        return messageParam;
    }

    public Map<String, Object> getArgs() {
        return args;
    }
}
