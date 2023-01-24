import com.base.Users.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExampleTest {

    @Test
    public void testUser() {
        User t = new User("d", "123");
        assertNotNull(t);
    }
}
