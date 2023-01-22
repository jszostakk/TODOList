import com.base.Commands.CreateCommand;
import com.base.Notes.NoteBuilderWithoutDate;
import com.base.Notes.NoteWithoutDate;
import com.base.TODOList;
import com.base.Tags.TagHealth;
import com.base.Tags.UserTagProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {
    private final int idOwner = 0;
    private final TODOList todoList = new TODOList(new UserTagProxy(idOwner, TagHealth.getInstance()));

    @Test
    public void createWithoutDateTest(){
        int choice = 1;
        String content = "message";
        NoteBuilderWithoutDate builder = new NoteBuilderWithoutDate();

        UserTagProxy tagHealthInstance = new UserTagProxy(idOwner, TagHealth.getInstance());
        tagHealthInstance.getNoteList().add(new NoteWithoutDate(idOwner, content));

        CreateCommand c = new CreateCommand(todoList, choice, content, builder, idOwner);
        c.execute();

        assertEquals(todoList.getTagHealth().getNoteList().get(0).toString(), tagHealthInstance.getNoteList().get(0).toString());
    }
}
