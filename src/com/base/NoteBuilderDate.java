package com.base;

import java.util.Date;

public class NoteBuilderDate implements NoteBuilder {
    private String tag;
    private String text;
    private Date date;


    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NoteDate getResult() {
        return new NoteDate(tag, text, date);
    }

    public void reset() {
        setTag("");
        setText("");
        setDate(null);
    }


}
