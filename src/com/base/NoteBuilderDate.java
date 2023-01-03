package com.base;

import java.util.Date;

public class NoteBuilderDate implements NoteBuilder {
    private String text;
    private String date;


    @Override
    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NoteDate getResult() {
        return new NoteDate(text, date);
    }

    public void reset() {
        setText(null);
        setDate(null);
    }


}
