package com.base;

public class NoteBuilderWithoutDate implements NoteBuilder {
    private String tag;
    private String text;


    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public NoteWithoutDate getResult() {
        return new NoteWithoutDate(tag, text);
    }

    public void reset() {
        setTag("");
        setText("");
    }


}
