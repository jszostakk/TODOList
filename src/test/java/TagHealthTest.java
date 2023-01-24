import com.base.Notes.NoteDate;
import com.base.Notes.NoteInterface;
import com.base.Notes.NoteWithoutDate;
import com.base.Tags.TagHealth;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TagHealthTest {
    @Test
    public void getNoteListTest() {

        //given
        ArrayList<NoteInterface> noteListMock = createNoteList();
        TagHealth tagHealthMock = mock(TagHealth.class);
        when(tagHealthMock.getNoteList()).thenReturn(noteListMock);

        //when
        ArrayList<NoteInterface> noteList = tagHealthMock.getNoteList();

        //then
        assertThat(noteList, hasSize(2));
    }

    private ArrayList<NoteInterface> createNoteList() {
        NoteInterface note1 = new NoteDate(1, "Note 1", "24-01-2023");
        NoteInterface note2 = new NoteWithoutDate(1, "Note 2");
        ArrayList<NoteInterface> noteListMock = new ArrayList<>();
        noteListMock.add(note1);
        noteListMock.add(note2);
        return noteListMock;
    }
}
