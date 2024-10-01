package com.pattern.decorate.textEditor;

public class SmallCaseEditor implements TextEditor{
    private TextEditor textEditor;

    public SmallCaseEditor(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public String getText() {
        return this.textEditor.getText().toLowerCase();
    }
}
