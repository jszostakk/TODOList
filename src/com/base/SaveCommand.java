package com.base;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaveCommand extends Command {
    private final ArrayList<NoteInterface> healthBackup;
    private final ArrayList<NoteInterface> studyBackup;

    public Memento takeSnapshot(){
        return new Memento(this.healthBackup, this.studyBackup);
    }

    public SaveCommand(TODOList todo, TagHealth tagHealth, TagStudy tagStudy) {
        super(todo);
        this.healthBackup = new ArrayList<>(tagHealth.noteList);
        this.studyBackup = new ArrayList<>(tagStudy.noteList);
    }

    @Override
    public boolean execute() {
        Memento memento = this.takeSnapshot();
        todo.addToSaves(memento);
        return true;
    }
}