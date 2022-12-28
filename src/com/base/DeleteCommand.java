package com.base;

public class DeleteCommand extends Command {
    int index;

    public DeleteCommand(TODOList todo, int index) {
        super(todo);
        this.index = index;
    }

    @Override
    public boolean execute() {
        todo.removeFromList(index);

        return true;
    }
}
