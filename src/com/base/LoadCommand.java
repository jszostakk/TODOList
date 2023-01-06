package com.base;

import java.util.ArrayList;

public class LoadCommand extends Command {
    Memento memento;

    public LoadCommand(TODOList todo, int index, ArrayList<Memento> mementos) {
        super(todo);
        this.memento = mementos.get(index);
    }


    @Override
    public boolean execute() {
        todo.setNoteList(memento.getHealthTagBackup(), memento.getStudyTagBackup());

        return true;
    }
}
