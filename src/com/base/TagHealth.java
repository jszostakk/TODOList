package com.base;

import java.util.ArrayList;

public class TagHealth implements Tag {
    private static TagHealth instance;
    public final ArrayList<NoteInterface> noteList = new ArrayList<>();
    private NoteBuilderDate noteBuilderDate;
    private NoteBuilderWithoutDate noteBuilderWithoutDate;


    public static TagHealth getInstance() {
        if (instance == null) {
            instance = new TagHealth();
        }
        return instance;
    }
}
