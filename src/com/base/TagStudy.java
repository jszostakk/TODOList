package com.base;

import java.util.ArrayList;

public class TagStudy implements Tag{
    private static TagStudy instance;
    private final ArrayList<NoteInterface> noteList = new ArrayList<>();
    private NoteBuilderDate noteBuilderDate;
    private NoteBuilderWithoutDate noteBuilderWithoutDate;


    @Override
    public void addNote() {

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
