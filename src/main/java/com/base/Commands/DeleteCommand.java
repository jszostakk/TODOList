package com.base.Commands;

import com.base.*;

public class DeleteCommand extends Command {
    int choice;
    int index;

    public DeleteCommand(TODOList todo, int choice, int index) {
        super(todo);
        this.choice = choice;
        this.index = index;
    }

    @Override
    public boolean execute() {
        todo.removeFromList(choice, index);

        return true;
    }
}
