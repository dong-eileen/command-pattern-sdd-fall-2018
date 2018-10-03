package com.command;

import java.util.List;

public class AddText implements Command {
    private Image image;
    private String text;
    private List<String> previousText;

    public AddText(Image image, String text) {
        this.image = image;
        this.text = text;
    }

    public void execute() {
        System.out.println("Command: Adding text to image...");
        previousText = image.getTextList();
        image.addText(text);
        image.printImage();
    }

    public void undo() {
        System.out.println("Command: Undoing add text...");
        image.setTextList(previousText);
        image.printImage();
    }
}
