package com.design.splitwise.command;

public interface Command {
    boolean match(String input);
    void execute(String input);

}
