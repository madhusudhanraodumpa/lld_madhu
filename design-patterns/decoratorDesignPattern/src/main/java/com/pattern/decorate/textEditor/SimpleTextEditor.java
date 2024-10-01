package com.pattern.decorate.textEditor;

public class SimpleTextEditor implements TextEditor{

    private String text;

    public SimpleTextEditor(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
