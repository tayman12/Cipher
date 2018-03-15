package org.example.cipher.model;

public class Message {

    private int encodeTimes;
    private String text;

    public int getEncodeTimes() {
        return encodeTimes;
    }

    public void setEncodeTimes(int encodeTimes) {
        this.encodeTimes = encodeTimes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
