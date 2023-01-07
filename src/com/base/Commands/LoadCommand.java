package com.base.Commands;

import java.util.ArrayList;
import com.base.*;

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
