package com.base;

public class NoteBuilderWithoutDate implements NoteBuilder {

    private String text;



    @Override
    public void setText(String text) {
        this.text = text;
    }

    public NoteWithoutDate getResult() {
        return new NoteWithoutDate(text);
    }

    public void reset() {
        setText(null);
    }


}
