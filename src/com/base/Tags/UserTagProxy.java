package com.base.Tags;

import com.base.Notes.NoteInterface;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserTagProxy extends Tag{
    Tag instance;
    int userId;

    public UserTagProxy(int userId, Tag instance){
        this.userId=userId;
        this.instance=instance;
        this.noteList = new ArrayList<>(instance.getNoteList().stream().filter(c -> c.getID_owner() == userId).collect(Collectors.toList()));
    }
}