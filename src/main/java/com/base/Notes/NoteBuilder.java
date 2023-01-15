package com.base.Notes;

public interface NoteBuilder {
    void setText(String text);
    void setID_owner(int ID_owner);
    public NoteInterface getResult();
    public void reset();
}
