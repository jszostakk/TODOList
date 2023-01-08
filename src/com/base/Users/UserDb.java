package com.base.Users;

import com.base.Notes.NoteBuilderDate;
import com.base.Notes.NoteBuilderWithoutDate;
import com.base.Notes.NoteInterface;
import com.base.Tags.Tag;
import com.base.Tags.TagHealth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDb {
        private static com.base.Users.UserDb instance;
        public static final Map userList = new HashMap<Integer, User>();

        private static Integer nextUserId=0;

        public static com.base.Users.UserDb getInstance() {
            if (instance == null) {
                instance = new com.base.Users.UserDb();
            }
            return instance;
        }

        public static void addUser(User user){
            user.setUserId(nextUserId);
            userList.put(nextUserId,user);
            nextUserId++;
        }

        public static User getUser(Integer id){
            return (User) userList.get(id);
        }

        public static List<User> getUsers(){
            return new ArrayList<User>(userList.values());
        }

    public static int getNextUserId(){
            return nextUserId;
        }
}
