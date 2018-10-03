package com.command;

import java.util.Scanner;

public class Client {

    public static void receiveAddTextInput(Image image, EventHandler eventHandler, String inputText) {
        Command addText = new AddText(image, inputText);
        eventHandler.receiveCommand(addText);
    }

    public static void receiveItalicizeTextInput(Image image, EventHandler eventHandler) {
        eventHandler.receiveCommand(new ItalicizeText(image));
    }

    public static void receiveUndoInput(EventHandler eventHandler) {
        eventHandler.undoCommand();
    }

    public static void handleInput(Image image, EventHandler eventHandler) {
        Scanner in = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("\nEnter a command: ");
            userInput = in.nextLine();
            if ("a".equals(userInput)) { // add text command
                System.out.println("Enter the text to add (under 46 characters): ");
                receiveAddTextInput(image, eventHandler, in.nextLine());
            } else if ("i".equals(userInput)) { // italicize text command
                receiveItalicizeTextInput(image, eventHandler);
            } else if ("u".equals(userInput)) { // undo command
                receiveUndoInput(eventHandler);
            }
        } while (!"q".equals(userInput));
        System.out.println("\nExiting...");
    }

    public static void main(String[] args) {
        /* set up receiver and invoker */
        Image image = new Image();
        EventHandler eventHandler = new EventHandler();

        System.out.println("Command list:");
        System.out.println("'a' = add text");
        System.out.println("'i' = italicize text");
        System.out.println("'u' = undo last command");
        System.out.println("'q' = quit");

        handleInput(image, eventHandler);

//        /* set up requests for adding and italicizing text */
//        Command addLine1 = new AddText(image, "Line 1");
//        Command addLine2 = new AddText(image, "Line 2");
//        Command italicizeText = new ItalicizeText(image);
//
//        /* have the invoker take in the requests */
//        eventHandler.receiveCommand(addLine1);
//        eventHandler.receiveCommand(addLine2);
//        eventHandler.receiveCommand(italicizeText);
//
//        /* the user made a mistake, requests undo */
//        eventHandler.undoCommand();
//        eventHandler.undoCommand();
    }
}
