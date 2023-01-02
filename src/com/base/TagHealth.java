package com.base;

import java.util.ArrayList;

public class TagHealth implements Tag {
    private final ArrayList<NoteWithoutDate> noteWithoutDateList = new ArrayList<>();
    private final ArrayList<NoteDate> noteDateList = new ArrayList<>();
    private NoteBuilderDate noteBuilderDate;
    private NoteBuilderWithoutDate noteBuilderWithoutDate;

    @Override
    public void addNote() {
        System.out.println("To create note with date use command:\n\t 2, if Note without Date");
    }

    @Override
    public void deleteNote() {

    }

    @Override
    public void changeNote() {

    }
}
