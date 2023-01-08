package com.base.Tags;

import com.base.Notes.NoteInterface;

import java.util.ArrayList;

public abstract class Tag {
    private final ArrayList<NoteInterface> noteList = new ArrayList<>();

    public ArrayList<NoteInterface> getNoteList(){
        return this.noteList;
    }
}