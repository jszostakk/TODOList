package com.base;

import java.util.Date;

public class NoteWithoutDate implements NoteInterface{
    private String text;
    private Boolean done = false;

    public NoteWithoutDate(String text) {
        this.text = text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void setDone() {
        this.done = true;
    }

    public String toString() {
        return text + " " + " " + done;
    }
}
