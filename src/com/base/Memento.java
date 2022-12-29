package com.base;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

public class Memento {
    private final ArrayList<Note> notesBackup;
    LocalTime time;

    public Memento(ArrayList<Note> notesBackup) {
        this.notesBackup = notesBackup;
        this.time = LocalTime.now();
    }

    public LocalTime getTime(){
        return time;
    }
    ArrayList<Note> getBackup() {
        return notesBackup;
    }
}
