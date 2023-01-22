import com.base.Commands.CreateCommand;
import com.base.Notes.NoteBuilderWithoutDate;
import com.base.TODOList;
import com.base.Tags.Tag;
import com.base.Tags.UserTagProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {
    private TODOList todoList = new TODOList();

    @Test
    public void createWithoutDateTest(){
        int choice = 1;
        String content = "message";
        NoteBuilderWithoutDate builder = new NoteBuilderWithoutDate();
        int idOwner = 0;

        Tag instance; //jak zainicjalizować obiekt Tag?? XD
        UserTagProxy stub1 = new UserTagProxy(0, instance);

        CreateCommand c = new CreateCommand(todoList, choice, content.toString(), builder, idOwner);
        c.execute();

        assertEquals(todoList.getTagHealth(), stub1);
    }
}
