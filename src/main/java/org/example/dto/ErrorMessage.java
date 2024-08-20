package org.example.dto;

import lombok.Builder;

import java.util.Map;

@Builder
public class ErrorMessage {

    private Map<String, Object> args;

    private String code;

    private String userMessage;

    private String devMessage;
}
