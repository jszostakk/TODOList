import com.base.Notes.NoteBuilderWithoutDate;
import com.base.Notes.NoteWithoutDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteBuilderWithoutDateTest {

    @Test
    public void createNoteWithoutDateWithBuilderTest(){
        int idOwner = 1;
        String content = "message";
        String date = "10-01-2023";
        NoteBuilderWithoutDate builder = new NoteBuilderWithoutDate();
        builder.setID_owner(idOwner);
        builder.setText(content);

        NoteWithoutDate noteWithoutDate = new NoteWithoutDate(idOwner, content);

        assertEquals(builder.getResult().toString(), noteWithoutDate.toString());
    }
}
