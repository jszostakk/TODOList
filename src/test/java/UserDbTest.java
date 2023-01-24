import com.base.Users.User;
import com.base.Users.UserDb;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


public class UserDbTest {
    @Test
    public void getUserTest() {

        //given
        int id = UserDb.getNextUserId();
        User testUser = new User("aa", "123");
        UserDb.addUser(testUser);

        //when
        User userFromDb = UserDb.getUser(id);

        //then
        assertEquals(testUser, userFromDb);
    }

    @Test
    public void getUsersTest() {

        //given
        User testUser1 = new User("aa", "123");
        User testUser2 = new User("bb", "321");
        UserDb.addUser(testUser1);
        UserDb.addUser(testUser2);

        //when
        List<User> userList = UserDb.getUsers();

        //then
        MatcherAssert.assertThat(userList, containsInAnyOrder(
                hasProperty("username", is("aa")),
                hasProperty("username", is("bb"))
        ));
    }

    @Test
    public void getInstanceTest() {

        //given

        //when
        UserDb userdb = UserDb.getInstance();

        //then
        Assertions.assertNotNull(userdb);
    }
}
