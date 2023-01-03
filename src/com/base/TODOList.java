package com.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TODOList {
    private final ArrayList<Note> noteList = new ArrayList<>();
    private final ArrayList<Memento> backups = new ArrayList<>();
    private final TagStudy tagStudy = TagStudy.getInstance();
    private final TagHealth tagHealth = TagHealth.getInstance();

    public void addToTagStudy(NoteInterface note) {
        this.tagStudy.noteList.add(note);
    }
    public void addToTagHealth(NoteInterface note) {
        this.tagHealth.noteList.add(note);
    }

    public void addToSaves(Memento memento) {
        this.backups.add(memento);
    }

    public ArrayList<Memento> getBackups() {
        return backups;
    }

    public boolean printBackups() {
        System.out.println("=============================");
        if (backups.isEmpty()) {
            System.out.println("\nThere are no backups here!\n");
            System.out.println("=============================");
            return false;
        }
        for (Memento memento :
                backups) {
            System.out.println("index: " + backups.indexOf(memento) + "\ttime: " + memento.getTime());
        }
        System.out.println("=============================");
        return true;
    }

    public ArrayList<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(ArrayList<Note> notes) {
        noteList.clear();
        noteList.addAll(notes);
    }

    public void removeFromList(int index) {
        this.noteList.remove(index);
    }

    public void editContent(int index, String content) {
        Note note = new Note(content);
        this.noteList.set(index, note);
    }

    private void executeCommand(Command command) {
        command.execute();
    }

    private String insertSomething(Scanner scan){
        System.out.print("input-> ");
        return scan.nextLine();
    }

    public void init() {
        TODOList todo = this;
        NoteBuilderDate builderDate = new NoteBuilderDate();
        NoteBuilderWithoutDate builderWithoutDate = new NoteBuilderWithoutDate();

        HelpCommand initialHelp = new HelpCommand(todo);
        executeCommand(initialHelp);

        Scanner scan = new Scanner(System.in);

        while (true) {
            String command = insertSomething(scan);
            String[] parts = command.split(" ");
            parts[0] = parts[0].toLowerCase();

            switch (parts[0]) {
                case "create" -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Write with spacebar :\n\tHealth or Study?\n\tDate or WithoutDate\n\tIf \"Date\", write it yyyy-MM-dd");
                    String choice = insertSomething(scanner);
                    String[] choiceParts = choice.split(" ");
                    choiceParts[0] = choiceParts[0].toLowerCase();
                    choiceParts[1] = choiceParts[1].toLowerCase();

                    StringBuilder content = new StringBuilder();
                    for (int i = 1; i < parts.length; i++) {
                        content.append(parts[i]).append(" ");
                    }
                    if (choiceParts[0].equals("health")) {
                        if (choiceParts[1].equals("date")) {
                            CreateCommand c = new CreateCommand(todo, content.toString(), builderDate, choiceParts[2], "Health");
                            executeCommand(c);
                        }
                        else if (choiceParts[1].equals("withoutdate")) {
                            CreateCommand c = new CreateCommand(todo, content.toString(), builderWithoutDate, "Health");
                            executeCommand(c);
                        }
                    }

                }
                case "delete" -> {
                    int index = Integer.parseInt(parts[1]);
                    DeleteCommand c = new DeleteCommand(todo, index);
                    executeCommand(c);
                }
                case "edit" -> {
                    int index = Integer.parseInt(parts[1]);

                    StringBuilder content = new StringBuilder();

                    for (int i = 2; i < parts.length; i++) {
                        content.append(parts[i]).append(" ");
                    }

                    EditCommand c = new EditCommand(todo, index, content.toString());
                    executeCommand(c);
                }
                case "print" -> {
                    System.out.println("=============================");
                    for (Note note :
                            noteList) {
                        System.out.println("\n" + "Index: " + noteList.indexOf(note) + "\n" + note.getContent() + "\n");
                    }
                    if (noteList.isEmpty()) {
                        System.out.println("\nThere are no notes here!\n");
                    }
                    System.out.println("=============================");
                }
                case "save" -> {
                    SaveCommand c = new SaveCommand(todo, getNoteList());
                    executeCommand(c);
                }
                case "load" -> {
                    System.out.println("Your backups: ");
                    if (this.printBackups()) {
                        System.out.println("Which one do you want to load?");

                        int index = Integer.parseInt(insertSomething(scan));
                        LoadCommand c = new LoadCommand(todo, index, backups);
                        executeCommand(c);
                    }
                }
                case "exit" -> {
                    return;
                }
                default -> {
                    HelpCommand c = new HelpCommand(todo);
                    executeCommand(c);
                }
            }
        }
    }
}