package com.base;

public abstract class Command {
    public TODOList todo;

    Command(TODOList todo) {
        this.todo = todo;
    }

    public abstract boolean execute();
}
