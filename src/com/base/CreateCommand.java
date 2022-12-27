package com.base;

class CreateCommand extends Command {
    String content;

    public CreateCommand(Editor editor, String content) {
        super(editor);
        this.content = content;
    }

    @Override
    public boolean execute() {
        Note note = new Note(content);
        editor.addToList(note);

        return true;
    }
}