package com.command;

import java.util.Stack;

/* invoker */
public class EventHandler {
    private Stack<Command> commandHistory;

    public EventHandler() {
        commandHistory = new Stack<>();
    }

    public void receiveCommand(Command command) {
        System.out.println("\nEventHandler: Received command. Executing...");
        command.execute();
        commandHistory.add(command);
    }

    public void undoCommand() {
        System.out.println("\nEventHandler: Undoing the latest command...");
        Command command = commandHistory.pop();
        command.undo();
    }
}
