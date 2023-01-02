package com.base;

import java.util.ArrayList;

public class TagHealth implements Tag {
    private static TagStudy instance;
    private final ArrayList<NoteInterface> noteList = new ArrayList<>();
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

    public static TagStudy getInstance() {
        if (instance == null) {
            instance = new TagStudy();
        }
        return instance;
    }
}
