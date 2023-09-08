package com.geektrust.coursescheduling.commands.impl;

import com.geektrust.coursescheduling.commands.Command;
import com.geektrust.coursescheduling.exceptions.NoSuchCommandException;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private static final Map<String, Command> commandMap = new HashMap<>();

    public void addCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void executeCommand(String commandName, String[] tokens) {
        Command command = commandMap.get(commandName);

        if (command == null) {
            throw new NoSuchCommandException();
        }

        command.execute(tokens);
    }
}
