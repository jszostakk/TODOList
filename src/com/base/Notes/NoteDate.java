package com.base.Notes;

import java.util.Date;

public class NoteDate implements NoteInterface {
    private int ID_owner;
    protected String text;
    private String date;
    private String done = "No";

    protected NoteDate(int id, String text, String date) {
        this.ID_owner = id;
        this.text = text;
        this.date = date;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setID_owner(int ID_owner) {
        this.ID_owner = ID_owner;
    }

    public String getDate() {
        return date;
    }

    public String getDone() {
        return done;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDone() {
        this.done = "Yes";
    }

    public String toString() {
        return text + " " + date + " " + done;
    }

    public int getID_owner() {
        return ID_owner;
    }

    public int isDate(){
        return 1;
    }
}
