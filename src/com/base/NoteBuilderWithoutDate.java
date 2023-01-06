package com.base;

public class NoteBuilderWithoutDate implements NoteBuilder {

    private String text;
    private int ID_owner;


    @Override
    public void setText(String text) {
        this.text = text;
    }

    public void setID_owner(int ID_owner) {
        this.ID_owner = ID_owner;
    }

    public NoteWithoutDate getResult() {
        return new NoteWithoutDate(ID_owner, text);
    }

    public void reset() {
        setID_owner(-1);
        setText(null);
    }


}
