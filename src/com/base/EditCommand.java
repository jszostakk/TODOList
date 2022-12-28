package com.base;

public class EditCommand extends Command {
    int index;
    String newContent;

    public EditCommand(TODOList todo, int index, String newContent) {
        super(todo);
        this.index = index;
        this.newContent = newContent;
    }

    @Override
    public boolean execute() {
        todo.editContent(index, newContent);

        return true;
    }
}
