package org.example.dto;

import org.example.entity.Record;

public class RecordDto {

    public RecordDto(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return url;
    }
}
