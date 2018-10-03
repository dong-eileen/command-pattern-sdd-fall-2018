package com.command;

import java.util.List;

public class ItalicizeText implements Command {
    private Image image;
    private List<String> previousText;

    public ItalicizeText(Image image) {
        this.image = image;
    }

    public void execute() {
        System.out.println("Command: Italicizing text in image...");
        previousText = image.getTextList();
        image.italicizeText();
        image.printImage();
    }

    public void undo() {
        System.out.println("Command: Undoing italicize text...");
        image.setTextList(previousText);
        image.printImage();
    }
}
