package com.design.splitwise.command;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommandRegistry {
    private List<Command> commands;

    public CommandRegistry(CreateUserCommand createUserCommand, CreateGroupCommand createGroupCommand) {
        this.commands = new ArrayList<>();
        commands.add(createUserCommand);
        commands.add(createGroupCommand);
    }
    public void execute(String input) {
        for (Command command :commands) {
            if(command.match(input)) {
                command.execute(input);
                break;
            }
        }
    }
}
