package com.base;

import com.base.Commands.*;
import com.base.Notes.*;
import com.base.Tags.*;
import com.base.Users.UserDb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class TODOList {
    private final ArrayList<Memento> backups = new ArrayList<>();

    private UserTagProxy tagHealth;
    private UserTagProxy tagStudy;
    NoteBuilderDate builderDate = new NoteBuilderDate();
    NoteBuilderWithoutDate builderWithoutDate = new NoteBuilderWithoutDate();

    public TODOList(UserTagProxy tagHealth, UserTagProxy tagStudy, NoteBuilderDate builderDate, NoteBuilderWithoutDate builderWithoutDate) {
        this.tagHealth = tagHealth;
        this.tagStudy = tagStudy;
        this.builderDate = builderDate;
        this.builderWithoutDate = builderWithoutDate;
    }

    public TODOList(){}

    public TODOList(UserTagProxy tagHealth) {
       this.tagHealth = tagHealth;
    }

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
            int builderChoice = tagHealth.getNoteList().get(index).isDate();
            if (builderChoice == 1) {
                builderDate.setID_owner(tagHealth.getNoteList().get(index).getID_owner());
                builderDate.setDate(tagHealth.getNoteList().get(index).getDate());
                builderDate.setText(content);
                NoteDate newNote = builderDate.getResult();
                builderDate.reset();
                tagHealth.getNoteList().set(index, newNote);
            }
            else if (builderChoice == 0) {
                builderWithoutDate.setID_owner(tagHealth.getNoteList().get(index).getID_owner());
                builderWithoutDate.setText(content);
                NoteWithoutDate newNote = builderWithoutDate.getResult();
                builderWithoutDate.reset();
                tagHealth.getNoteList().set(index, newNote);
            }
        }
        if (choice == 2) {
            int builderChoice = tagStudy.getNoteList().get(index).isDate();
            if (builderChoice == 1) {
                builderDate.setID_owner(tagStudy.getNoteList().get(index).getID_owner());
                builderDate.setDate(tagStudy.getNoteList().get(index).getDate());
                builderDate.setText(content);
                NoteDate newNote = builderDate.getResult();
                builderDate.reset();
                tagStudy.getNoteList().set(index, newNote);
            }
            else if (builderChoice == 0) {
                builderWithoutDate.setID_owner(tagStudy.getNoteList().get(index).getID_owner());
                builderWithoutDate.setText(content);
                NoteWithoutDate newNote = builderWithoutDate.getResult();
                builderWithoutDate.reset();
                tagStudy.getNoteList().set(index, newNote);
            }
        }
    }

    private void executeCommand(Command command) {
        command.execute();
    }

    private String insertSomething(Scanner scan){
        System.out.print("input-> ");
        return scan.nextLine();
    }
    /*
    public String printNotes() {
        System.out.println("=============================");
        System.out.println("Health :");
        for (Iterator it = tagHealth.iterator(); it.hasNext(); ) {
            NoteInterface note = (NoteInterface) it.next();
            if(note.getDate() == null) {
                System.out.println("\n" + "Index: " + tagHealth.getNoteList().indexOf(note) + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
            }
            else {
                System.out.println("\n" + "Index: " + tagHealth.getNoteList().indexOf(note) + "\nDate: " + note.getDate() + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
            }
        }
        if (tagHealth.getNoteList().isEmpty()) {
            System.out.println("\nThere are no notes in this tag!\n");
        }
        System.out.println("=============================");
        System.out.println("Study :");
        for (Iterator it = tagStudy.iterator(); it.hasNext(); ) {
            NoteInterface note = (NoteInterface) it.next();
            if(note.getDate() == null) {
                System.out.println("\n" + "Index: " + tagStudy.getNoteList().indexOf(note) + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
            }
            else {
                System.out.println("\n" + "Index: " + tagStudy.getNoteList().indexOf(note) + "\nDate: " + note.getDate() + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
            }
        }
        if (tagStudy.getNoteList().isEmpty()) {
            System.out.println("\nThere are no notes in this tag!\n");
        }
    }
*/
    public void init(int id_owner) {
        tagHealth = new UserTagProxy(id_owner,TagHealth.getInstance());
        tagStudy = new UserTagProxy(id_owner,TagStudy.getInstance());

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
                    for (Iterator it = tagHealth.iterator(); it.hasNext(); ) {
                        NoteInterface note = (NoteInterface) it.next();
                        if(note.getDate() == null) {
                            System.out.println("\n" + "Index: " + tagHealth.getNoteList().indexOf(note) + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
                        }
                        else {
                            System.out.println("\n" + "Index: " + tagHealth.getNoteList().indexOf(note) + "\nDate: " + note.getDate() + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
                        }
                    }
                    if (tagHealth.getNoteList().isEmpty()) {
                        System.out.println("\nThere are no notes in this tag!\n");
                    }
                    System.out.println("=============================");
                    System.out.println("Study :");
                    for (Iterator it = tagStudy.iterator(); it.hasNext(); ) {
                        NoteInterface note = (NoteInterface) it.next();
                        if(note.getDate() == null) {
                            System.out.println("\n" + "Index: " + tagStudy.getNoteList().indexOf(note) + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
                        }
                        else {
                            System.out.println("\n" + "Index: " + tagStudy.getNoteList().indexOf(note) + "\nDate: " + note.getDate() + "\nTODO: " + note.getText() + "\nIs it done?: " + note.getDone() + "\n");
                        }
                    }
                    if (tagStudy.getNoteList().isEmpty()) {
                        System.out.println("\nThere are no notes in this tag!\n");
                    }

                }
                case "printb64" -> {
                    int choice = Integer.parseInt(parts[1]);
                    int index = Integer.parseInt(parts[2]);
                    NoteInterface note;

                    if(choice==1){
                        note =tagHealth.getNoteList().get(index);
                    }
                    else{
                        note = tagStudy.getNoteList().get(index);
                    }

                    NoteInterface converted;
                    if(note instanceof NoteWithoutDate){
                        converted = new NoteWithoutDateBase64(note.getID_owner(),note.getText());
                        System.out.println(converted.getText());
                    }

                    if(note instanceof NoteDate){
                        converted = new NoteDateBase64(note.getID_owner(),note.getText(),note.getDate());
                        System.out.println(converted.getText());
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
                case "done" -> {
                    int choice = Integer.parseInt(parts[1]);
                    int index = Integer.parseInt(parts[2]);
                    if (choice == 1) {
                        tagHealth.getNoteList().get(index).setDone();
                    }
                    if (choice == 2) {
                        tagStudy.getNoteList().get(index).setDone();
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