package com.base;

import java.util.ArrayList;
import java.util.Scanner;

class TODOList {
    private final ArrayList<Note> noteList = new ArrayList<>();
    private final ArrayList<Memento> backups = new ArrayList<>();

    public void addToList(Note note) {
        this.noteList.add(note);
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
        String something = scan.nextLine();
        return something;
    }

    public void init() {
        TODOList todo = this;

        HelpCommand initialHelp = new HelpCommand(todo);
        executeCommand(initialHelp);

        Scanner scan = new Scanner(System.in);

        while (true) {
            String command = insertSomething(scan);
            String[] parts = command.split(" ");
            parts[0] = parts[0].toLowerCase();

            switch (parts[0]) {
                case "create" -> {
                    StringBuilder content = new StringBuilder();

                    for (int i = 1; i < parts.length; i++) {
                        content.append(parts[i]).append(" ");
                    }

                    CreateCommand c = new CreateCommand(todo, content.toString());
                    executeCommand(c);
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
                default -> {
                    HelpCommand c = new HelpCommand(todo);
                    executeCommand(c);
                }
            }
        }
    }
}