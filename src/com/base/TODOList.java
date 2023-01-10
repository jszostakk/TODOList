package com.base;

import com.base.Commands.*;
import com.base.Notes.*;
import com.base.Tags.*;
import com.base.Users.UserDb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TODOList {
    private final ArrayList<Memento> backups = new ArrayList<>();

    private UserTagProxy tagHealth;
    private UserTagProxy tagStudy;


    public void addToTagHealth(NoteInterface note) {
        this.tagHealth.getNoteList().add(note);
    }
    public void addToTagStudy(NoteInterface note) {
        this.tagStudy.getNoteList().add(note);
    }

    public UserTagProxy getTagHealth() {
        return tagHealth;
    }

    public UserTagProxy getTagStudy() {
        return tagStudy;
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



    public void setNoteList(ArrayList<NoteInterface> healthNotes, ArrayList<NoteInterface> studyNotes) {
        tagHealth.getNoteList().clear();
        tagHealth.getNoteList().addAll(healthNotes);
        tagStudy.getNoteList().clear();
        tagStudy.getNoteList().addAll(studyNotes);
    }

    public void removeFromList(int choice, int index) {
        if (choice == 1) {
            tagHealth.getNoteList().remove(index);
        }
        if (choice == 2) {
            tagStudy.getNoteList().remove(index);
        }
    }

    public void editContent(int choice, int index, String content) {
        if (choice == 1 ) {
            NoteInterface note = tagHealth.getNoteList().get(index);
            note.setText(content);
            tagHealth.getNoteList().set(index, note);
        }
        if (choice == 2) {
            NoteInterface note = tagStudy.getNoteList().get(index);
            note.setText(content);
            tagStudy.getNoteList().set(index, note);
        }
    }

    private void executeCommand(Command command) {
        command.execute();
    }

    private String insertSomething(Scanner scan){
        System.out.print("input-> ");
        return scan.nextLine();
    }

    public void init(int id_owner) {
        tagHealth = new UserTagProxy(id_owner,TagHealth.getInstance());
        tagStudy = new UserTagProxy(id_owner,TagStudy.getInstance());

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
                    int choice = Integer.parseInt(parts[1]);
                    StringBuilder content = new StringBuilder();
                    for (int i = 2; i < parts.length; i++) {
                        content.append(parts[i]).append(" ");
                    }
                    System.out.println("If You want note with date, write \"yes [date, for example 25-10-2023]\"\nIf You don't need date, write down \"no\"");
                    String date = insertSomething(scan);
                    String[] date_parts = date.split(" ");
                    date_parts[0] = date_parts[0].toLowerCase();

                        if (date_parts[0].equals("yes")) {
                            CreateCommand c = new CreateCommand(todo, choice, content.toString(), builderDate, id_owner, date_parts[1]);
                            executeCommand(c);
                        }
                        if (date_parts[0].equals("no")) {
                            CreateCommand c = new CreateCommand(todo, choice, content.toString(), builderWithoutDate, id_owner);
                            executeCommand(c);
                        }

                }
                case "delete" -> {
                    int choice = Integer.parseInt(parts[1]);
                    int index = Integer.parseInt(parts[2]);
                    DeleteCommand c = new DeleteCommand(todo, choice, index);
                    executeCommand(c);
                }
                case "edit" -> {
                    int choice = Integer.parseInt(parts[1]);
                    int index = Integer.parseInt(parts[2]);

                    StringBuilder content = new StringBuilder();

                    for (int i = 3; i < parts.length; i++) {
                        content.append(parts[i]).append(" ");
                    }

                    EditCommand c = new EditCommand(todo, choice, index, content.toString());
                    executeCommand(c);
                }
                case "print" -> {
                    System.out.println("=============================");
                    System.out.println("Health :");
                    for (NoteInterface note :
                            tagHealth.getNoteList()) {
                        System.out.println("\n" + "Index: " + tagHealth.getNoteList().indexOf(note) + "\n" + note.getText() + "\n");
                    }
                    if (tagHealth.getNoteList().isEmpty()) {
                        System.out.println("\nThere are no notes in this tag!\n");
                    }
                    System.out.println("=============================");
                    System.out.println("Study :");
                    for (NoteInterface note :
                            tagStudy.getNoteList()) {
                        System.out.println("\n" + "Index: " + tagStudy.getNoteList().indexOf(note) + "\n" + note.getText() + "\n");
                    }
                    if (tagStudy.getNoteList().isEmpty()) {
                        System.out.println("\nThere are no notes in this tag!\n");
                    }

                }
                case "save" -> {
                    SaveCommand c = new SaveCommand(todo, getTagHealth(), getTagStudy());
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
                    System.exit(0);
                }
                default -> {
                    HelpCommand c = new HelpCommand(todo);
                    executeCommand(c);
                }
            }
        }
    }
}