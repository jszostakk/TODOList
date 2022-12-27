package com.base;

abstract class Command {
    public Editor editor;

    Command(Editor editor) {
        this.editor = editor;
    }

    public abstract boolean execute();
}
