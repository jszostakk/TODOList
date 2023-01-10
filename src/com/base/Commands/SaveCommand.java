package com.base.Commands;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.base.Notes.*;
import com.base.Tags.*;
import com.base.*;

public class SaveCommand extends Command {
    private final ArrayList<NoteInterface> healthBackup;
    private final ArrayList<NoteInterface> studyBackup;

    public Memento takeSnapshot(){
        return new Memento(this.healthBackup, this.studyBackup);
    }

    public SaveCommand(TODOList todo, UserTagProxy tagHealth, UserTagProxy tagStudy) {
        super(todo);
        this.healthBackup = new ArrayList<>(tagHealth.getNoteList());
        this.studyBackup = new ArrayList<>(tagStudy.getNoteList());
    }

    @Override
    public boolean execute() {
        Memento memento = this.takeSnapshot();
        todo.addToSaves(memento);
        return true;
    }
}