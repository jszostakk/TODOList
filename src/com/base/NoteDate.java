package com.base;

import java.util.Date;

public class NoteDate {
    private String tag;
    private String text;
    private Date date;
    private Boolean done = false;

    public NoteDate(String tag, String text, Date date) {
        this.tag = tag;
        this.text = text;
        this.date = date;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
