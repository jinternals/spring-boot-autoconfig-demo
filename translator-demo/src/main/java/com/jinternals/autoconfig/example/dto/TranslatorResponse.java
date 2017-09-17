package com.jinternals.autoconfig.example.dto;

public class TranslatorResponse {
    private String text;

    public TranslatorResponse() {
    }

    public TranslatorResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
