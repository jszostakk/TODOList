import com.base.Users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {
    User testUser;

    @BeforeEach
    public void initialize() {
        testUser = new User("aa", "123");
    }

    @Test
    public void getUserIdTest() {
        assertEquals(-1, testUser.getUserId());
    }

    @Test
    public void getUsernameTest() {
        assertEquals("aa", testUser.getUsername());
    }

    @Test
    public void setUserIdTest() {

        //given
        User userMock = mock(User.class);
        when(userMock.getUserId()).thenReturn(4);

        //when
        int userId = userMock.getUserId();

        //then
        assertNotEquals(-1, userId);
    }
}
