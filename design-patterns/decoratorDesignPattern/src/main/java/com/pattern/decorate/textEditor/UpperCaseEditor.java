package com.pattern.decorate.textEditor;

public class UpperCaseEditor implements TextEditor{
    private TextEditor textEditor;

    public UpperCaseEditor(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public String getText() {
        return textEditor.getText().toUpperCase();
    }
}
