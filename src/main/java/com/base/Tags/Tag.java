package com.base.Tags;

import com.base.Notes.NoteInterface;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Tag implements Iterable {
    ArrayList<NoteInterface> noteList = new ArrayList<>();

    public ArrayList<NoteInterface> getNoteList(){
        return this.noteList;
    }

    public Iterator iterator() {
        return new TagIterator(this);
    }
}