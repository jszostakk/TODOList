import com.base.Notes.NoteBuilder;
import com.base.Notes.NoteBuilderWithoutDate;
import com.base.Tags.TagHealth;
import com.base.Tags.UserTagProxy;
import com.base.Users.User;
import com.base.Users.UserDb;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTagProxyTest {
    static TagHealth tagHealth;
    static User testUser1;
    static User testUser2;
    static UserTagProxy userTagProxy;

    @BeforeAll
    public static void initializeTag() {
        testUser1 = new User("aa", "123");
        testUser2 = new User("bb", "321");
        UserDb.getInstance();
        UserDb.addUser(testUser1);
        UserDb.addUser(testUser2);
        tagHealth = TagHealth.getInstance();

        NoteBuilder noteBuilder1 = new NoteBuilderWithoutDate();
        noteBuilder1.setText("User1 note");
        noteBuilder1.setID_owner(testUser1.getUserId());
        tagHealth.getNoteList().add(noteBuilder1.getResult());

        NoteBuilder noteBuilder2 = new NoteBuilderWithoutDate();
        noteBuilder2.setID_owner(testUser2.getUserId());
        noteBuilder2.setText("User2 note");
        tagHealth.getNoteList().add(noteBuilder2.getResult());
        userTagProxy = new UserTagProxy(testUser1.getUserId(), tagHealth);
    }

    @Test
    public void checkUser1AccessToUser1Note() {
        assertTrue(userTagProxy.getNoteList().stream().anyMatch(note -> note.getText().equals("User1 note")));
    }

    @Test
    public void checkUser1AccessToUser2Note() {
        assertTrue(userTagProxy.getNoteList().stream().noneMatch(note -> note.getText().equals("User2 note")));
    }
}