package com.base.Tags;

import com.base.Notes.NoteInterface;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

class TagIterator implements Iterator {
    Tag tagInstance;
    Enumeration<NoteInterface> e;

    // constructor
    TagIterator(Tag obj) {
        this.tagInstance=obj;
        e= Collections.enumeration(obj.getNoteList());
    }

    // Checks if the next element exists
    public boolean hasNext() {
        return e.hasMoreElements();
    }

    // moves the cursor/iterator to next element
    public NoteInterface next() {
        return e.nextElement();
    }
}