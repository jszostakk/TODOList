package com.base;

import java.util.Date;

public class NoteBuilderDate implements NoteBuilder {
    private int ID_owner;
    private String text;
    private String date;


    @Override
    public void setText(String text) {
        this.text = text;
    }

    public void setID_owner(int ID_owner) {
        this.ID_owner = ID_owner;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NoteDate getResult() {
        return new NoteDate(ID_owner, text, date);
    }

    public void reset() {
        setID_owner(-1);
        setText(null);
        setDate(null);
    }


}
