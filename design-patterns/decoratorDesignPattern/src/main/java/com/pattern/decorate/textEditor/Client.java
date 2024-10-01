package com.pattern.decorate.textEditor;

public class Client {
    public static void main(String[] args) {

        TextEditor textEditor = new SmallCaseEditor(new UpperCaseEditor(new CapitalizeTextEditor(new SimpleTextEditor("Hello madhu sudhan rao"))));



        System.out.println(textEditor.getText());

    }
}
