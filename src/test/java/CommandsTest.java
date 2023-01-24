import com.base.Commands.CreateCommand;
import com.base.Commands.DeleteCommand;
import com.base.Commands.EditCommand;
import com.base.Notes.NoteBuilderWithoutDate;
import com.base.Notes.NoteDate;
import com.base.Notes.NoteWithoutDate;
import com.base.TODOList;
import com.base.Tags.TagHealth;
import com.base.Tags.UserTagProxy;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {
    private final int idOwner = 0;
    private final TODOList todoList = new TODOList(new UserTagProxy(idOwner, TagHealth.getInstance()));

    @Test
    public void createCommandWithoutDateTest() {

        //given
        int choice = 1;
        String content = "message";
        NoteBuilderWithoutDate builder = new NoteBuilderWithoutDate();
        NoteWithoutDate note = new NoteWithoutDate(idOwner, content);
        CreateCommand c = new CreateCommand(todoList, choice, content, builder, idOwner);

        //when
        c.execute();

        //then
        assertEquals(todoList.getTagHealth().getNoteList().get(0).toString(), note.toString());
    }

    @Test
    public void EditCommandTest() {

        //given
        todoList.getTagHealth().getNoteList().add(new NoteWithoutDate(1, "Test"));
        NoteWithoutDate note = new NoteWithoutDate(1, "Edit");
        int choice = 1;
        String content = "Edit";
        EditCommand command = new EditCommand(todoList, choice, 0, content);

        //when

        command.execute();

        //then
        assertEquals(todoList.getTagHealth().getNoteList().get(0).toString(), note.toString());
    }

    @Test
    public void DeleteCommandTest() {

        //given
        todoList.getTagHealth().getNoteList().add(new NoteWithoutDate(1, "Test1"));
        todoList.getTagHealth().getNoteList().add(new NoteDate(2, "Test2", "24-01-2023"));
        DeleteCommand command = new DeleteCommand(todoList, 1, 0);

        //when
        command.execute();

        //then
        assertThat(todoList.getTagHealth().getNoteList(), hasSize(1));
    }
}
