package com.base;

import java.util.Date;

public class NoteDate implements NoteInterface {
    private String text;
    private String date;
    private Boolean done = false;

    public NoteDate(String text, String date) {
        this.text = text;
        this.date = date;
    }



    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDone() {
        this.done = true;
    }

    public String toString() {
        return text + " " + date + " " + done;
    }
}
