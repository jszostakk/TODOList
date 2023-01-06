package com.base;


public class CreateCommand extends Command {
    String content;
    String date;
    NoteBuilder builder;
    int choice;

    public CreateCommand(TODOList todo, int choice, String content, NoteBuilderWithoutDate builder, int id) {
        super(todo);
        this.choice = choice;
        this.content = content;
        this.builder = builder;
        builder.setID_owner(id);
        builder.setText(content);

    }

    public CreateCommand(TODOList todo, int choice, String content, NoteBuilderDate builder, int id, String date) {
        super(todo);
        this.choice = choice;
        this.content = content;
        this.date = date;
        this.builder = builder;
        builder.setID_owner(id);
        builder.setDate(date);
        builder.setText(content);
    }

    @Override
    public boolean execute() {
        NoteInterface note = builder.getResult();
        builder.reset();
        if(choice == 1) {
            //System.out.println(note);
            todo.addToTagHealth(note);
        }
        if(choice == 2) {
            //System.out.println(note);
            todo.addToTagStudy(note);
        }
        return true;
    }
}