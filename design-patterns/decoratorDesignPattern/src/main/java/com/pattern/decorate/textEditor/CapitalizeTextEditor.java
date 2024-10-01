package com.pattern.decorate.textEditor;

public class CapitalizeTextEditor implements TextEditor{
    private TextEditor textEditor;

    public CapitalizeTextEditor(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public String getText() {
        String[] words = textEditor.getText().split("\\s+");
        StringBuilder capitalizedText = new StringBuilder();
        for (String word : words) {
            if (capitalizedText.length() > 0) {
                capitalizedText.append(" ");
            }
            capitalizedText.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase());
        }
        return capitalizedText.toString();
    }
}
