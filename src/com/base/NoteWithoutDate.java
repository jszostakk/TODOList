package com.base;

import java.util.Date;

public class NoteWithoutDate implements NoteInterface{
    private String tag;
    private String text;
    private Boolean done = false;

    public NoteWithoutDate(String tag, String text) {
        this.tag = tag;
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone() {
        this.done = true;
    }
}
