package com.pattern.decorate.textEditor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextEditorTest {
    @Test
    void testUppercaseDecorator() {
        TextEditor textEditor = new UpperCaseEditor(new SimpleTextEditor("Hello World"));
        Assertions.assertEquals("HELLO WORLD", textEditor.getText());
    }

    @Test
    void testLowercaseDecorator() {
        TextEditor textEditor = new SmallCaseEditor(new SimpleTextEditor("Hello World"));
        Assertions.assertEquals("hello world", textEditor.getText());
    }

    @Test
    void testCapitalizeDecorator() {
        TextEditor textEditor = new CapitalizeTextEditor(new SimpleTextEditor("hello world"));
        Assertions.assertEquals("Hello World", textEditor.getText());
    }

    @Test
    void testCombinedDecorators() {
        TextEditor textEditor = new UpperCaseEditor(new CapitalizeTextEditor(new SmallCaseEditor(new SimpleTextEditor("hELLO wORLD"))));
        Assertions.assertEquals("HELLO WORLD", textEditor.getText());
    }
}
