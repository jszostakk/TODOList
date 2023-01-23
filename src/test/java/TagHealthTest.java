import com.base.Notes.NoteInterface;
import com.base.Tags.TagHealth;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TagHealthTest {
    @Test
    public void getNoteListTest(){
        TagHealth tagHealthMock = mock(TagHealth.class);
        when(tagHealthMock.getNoteList()).thenReturn(new ArrayList<>());

        ArrayList<NoteInterface> noteList = tagHealthMock.getNoteList();
        assertNotNull(noteList);
    }
}
