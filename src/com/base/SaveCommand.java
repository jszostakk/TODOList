package com.base;

import java.util.ArrayList;

public class SaveCommand extends Command {
    private final ArrayList<Note> backup;

    public Memento takeSnapshot(){
        return new Memento(this.backup);
    }

    public SaveCommand(TODOList todo, ArrayList<Note> notes) {
        super(todo);
        this.backup = new ArrayList<>(notes);
    }

    @Override
    public boolean execute() {
        Memento memento = this.takeSnapshot();
        todo.addToSaves(memento);
        return true;
    }
}