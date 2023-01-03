package com.base;


public class CreateCommand extends Command {
    String content;
    String date;
    NoteBuilder builder;
    String tag;

    public CreateCommand(TODOList todo, String content, NoteBuilderWithoutDate builder, String tag) {
        super(todo);
        this.content = content;
        this.builder = builder;
        builder.setText(content);
        this.tag = tag;
    }

    public CreateCommand(TODOList todo, String content, NoteBuilderDate builder, String date, String tag) {
        super(todo);
        this.content = content;
        this.date = date;
        this.builder = builder;
        builder.setDate(date);
        builder.setText(content);
        this.tag = tag;
    }

    @Override
    public boolean execute() {
        NoteInterface note = builder.getResult();
        builder.reset();
        if(tag.equals("Health")) {
            System.out.println(note);
            todo.addToTagHealth(note);
        }
        if(tag.equals("Study")) {
            System.out.println(note);
            todo.addToTagStudy(note);
        }
        return true;
    }
}