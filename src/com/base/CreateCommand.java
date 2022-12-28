package com.base;

class CreateCommand extends Command {
    String content;

    public CreateCommand(TODOList todo, String content) {
        super(todo);
        this.content = content;
    }

    @Override
    public boolean execute() {
        Note note = new Note(content);
        todo.addToList(note);

        return true;
    }
}