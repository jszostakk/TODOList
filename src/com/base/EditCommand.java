package com.base;

public class EditCommand extends Command {
    int choice;
    int index;
    String newContent;

    public EditCommand(TODOList todo, int choice, int index, String newContent) {
        super(todo);
        this.choice = choice;
        this.index = index;
        this.newContent = newContent;
    }

    @Override
    public boolean execute() {
        todo.editContent(choice, index, newContent);

        return true;
    }
}
