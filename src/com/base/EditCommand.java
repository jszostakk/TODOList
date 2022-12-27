package com.base;

public class EditCommand extends Command {
    int index;
    String newContent;

    public EditCommand(Editor editor, int index, String newContent) {
        super(editor);
        this.index = index;
        this.newContent = newContent;
    }

    @Override
    public boolean execute() {
        editor.editContent(index, newContent);

        return true;
    }
}
