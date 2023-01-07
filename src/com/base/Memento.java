package com.base;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

public class Memento {

    private final ArrayList<NoteInterface> healthTagBackup;
    private final ArrayList<NoteInterface> studyTagBackup;
    LocalTime time;

    public Memento(ArrayList<NoteInterface> healthTagBackup, ArrayList<NoteInterface> studyTagBackup) {
        this.healthTagBackup = healthTagBackup;
        this.studyTagBackup = studyTagBackup;
        this.time = LocalTime.now();
    }

    public ArrayList<NoteInterface> getHealthTagBackup() {
        return healthTagBackup;
    }

    public ArrayList<NoteInterface> getStudyTagBackup() {
        return studyTagBackup;
    }

    public LocalTime getTime(){
        return time;
    }
}
