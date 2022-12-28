package com.base;

import java.util.ArrayList;
import java.util.Scanner;

class TODOList {
    private final ArrayList<Note> noteList = new ArrayList<>();

    public void addToList(Note note) {
        this.noteList.add(note);
    }

    public void removeFromList(int index) {
        this.noteList.remove(index);
    }

    public void editContent(int index, String content){
        Note note = new Note(content);
        this.noteList.set(index, note);
    }

    private void executeCommand(Command command) {
        command.execute();
    }

    public void init() {
        TODOList todo = this;

        Scanner scan = new Scanner(System.in);
        while (true) {
            String command = scan.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "Create" -> {
                    StringBuilder content = new StringBuilder();

                    for (int i = 1; i < parts.length; i++) {
                        content.append(parts[i]).append(" ");
                    }

                    CreateCommand c = new CreateCommand(todo, content.toString());
                    executeCommand(c);

                    break;
                }
                case "Delete" -> {
                    int index = Integer.parseInt(parts[1]);
                    DeleteCommand c = new DeleteCommand(todo, index);
                    executeCommand(c);

                    break;
                }
                case "Edit" -> {
                    int index = Integer.parseInt(parts[1]);

                    StringBuilder content = new StringBuilder();

                    for (int i = 2; i < parts.length; i++) {
                        content.append(parts[i]).append(" ");
                    }

                    EditCommand c = new EditCommand(todo, index, content.toString());
                    executeCommand(c);
                    break;
                }
                case "Print" -> {
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
            }
        }
    }
}