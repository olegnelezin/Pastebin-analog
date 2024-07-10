package org.example.dto;

public class PasteDto {

    public PasteDto(String title, String text) {
        this.title = title;
        this.text = text;
    }

    private String title;

    private String text;

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
