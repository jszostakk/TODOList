package com.base;

import com.base.Users.User;
import com.base.Users.UserDb;

import java.util.Scanner;

public class Main {
    private static Integer userId=-1;
    public static void main(String[] args) {
        UserDb instance = UserDb.getInstance();
        TODOList todo = new TODOList();
        if(instance.getNextUserId()==0){ //if no users, choose registration
            register();
        }
        else {
            int option;
            System.out.println("Do you want to login(0) or register(1):");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if(option==1)
                register();
        }
        printUsers();
        if(!login()){
            System.out.println("Wrong password");
            System.exit(-1);
        }
        todo.init(userId);
    }

    public static void printUsers(){
        UserDb instance = UserDb.getInstance();
        System.out.println("\nId\t\tUsername");
        for (User u : instance.getUsers()){
            System.out.println(u.getUserId() + "\t\t" + u.getUsername());
        }
    }

    public static boolean login(){
        UserDb instance = UserDb.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type Id of the user that you want to use:");
        userId=scanner.nextInt();
        scanner.nextLine(); //catch newline
        User userObj = instance.getUser(userId);
        System.out.println("Enter password:");
        String password = scanner.nextLine().trim();

        return userObj.getPassword().equals(password);
    }

    public static void register(){
        System.out.println("---- User Registration ----");
        UserDb instance = UserDb.getInstance();
        Scanner scanner = new Scanner(System.in);

        User newUser = new User();
        System.out.println("Enter username:");
        newUser.setUsername(scanner.nextLine());
        System.out.println("Enter password:");
        newUser.setPassword(scanner.nextLine());

        instance.addUser(newUser);
    }
}