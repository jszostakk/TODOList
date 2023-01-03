package com.base;

import java.util.ArrayList;

public class TagStudy implements Tag{
    private static TagStudy instance;
    public final ArrayList<NoteInterface> noteList = new ArrayList<>();
    private NoteBuilderDate noteBuilderDate;
    private NoteBuilderWithoutDate noteBuilderWithoutDate;


    public static TagStudy getInstance() {
        if (instance == null) {
            instance = new TagStudy();
        }
        return instance;
    }
}
