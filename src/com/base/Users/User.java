package com.base.Users;

public class User {
    private final int userId;
    private string username;
    private string password;

    public User(string username, string password){
        this.userId=UserDb.getNextId();
        this.username=username;
        this.password=password;
    }
}
