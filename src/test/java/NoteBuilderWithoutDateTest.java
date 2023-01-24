import com.base.Notes.NoteBuilderWithoutDate;
import com.base.Notes.NoteWithoutDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteBuilderWithoutDateTest {

    @Test
    public void createNoteWithoutDateWithBuilderTest() {

        //given
        int idOwner = 1;
        String content = "message";
        String date = "10-01-2023";
        NoteWithoutDate noteWithoutDate = new NoteWithoutDate(idOwner, content);
        NoteBuilderWithoutDate builder = new NoteBuilderWithoutDate();

        //when
        builder.setID_owner(idOwner);
        builder.setText(content);

        //then
        assertEquals(builder.getResult().toString(), noteWithoutDate.toString());
    }
}
