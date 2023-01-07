package com.base.Commands;

import com.base.TODOList;

public abstract class Command {
    public TODOList todo;

    public Command(TODOList todo) {
        this.todo = todo;
    }

    public abstract boolean execute();
}
