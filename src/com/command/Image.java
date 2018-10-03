package com.command;

import java.util.ArrayList;
import java.util.List;

/* receiver class; a rectangular frame where you can add textList and it will be printed on separate lines */
public class Image {
    private List<String> textList;

    public Image() {
        textList = new ArrayList<>();
    }

    public void addText(String text) {
        this.textList.add(text);
    }

    public void italicizeText() {
        List<String> newTextList = new ArrayList<>();
        for (String text : textList) {
            newTextList.add("<i>" + text + "</i>");
        }
        textList = newTextList;
    }

    public List<String> getTextList() {
        return new ArrayList<>(textList);
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    public void printImage() {
        System.out.println(new String(new char[50]).replace('\0', '-'));
        for (String text : getTextList()) {
            System.out.println("| " + text + new String(new char[46-text.length()]).replace('\0', ' ') + " |");
        }
        System.out.println(new String(new char[50]).replace('\0', '-'));
    }
}
