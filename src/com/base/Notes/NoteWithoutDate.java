package com.base.Notes;

import java.util.Date;

public class NoteWithoutDate implements NoteInterface{
    private int ID_owner;
    private String text;
    private Boolean done = false;

    public NoteWithoutDate(int id, String text) {
        this.ID_owner = id;
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setID_owner(int ID_owner) {
        this.ID_owner = ID_owner;
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
