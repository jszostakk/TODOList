package com.base;

public class DeleteCommand extends Command {
    int index;

    public DeleteCommand(Editor editor, int index) {
        super(editor);
        this.index = index;
    }

    @Override
    public boolean execute() {
        editor.removeFromList(index);

        return true;
    }
}
