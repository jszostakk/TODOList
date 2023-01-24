import com.base.Notes.NoteBuilderDate;
import com.base.Notes.NoteDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteBuilderDateTest {

    @Test
    public void createNoteDateWithBuilderTest() {

        //given
        int idOwner = 1;
        String content = "message";
        String date = "10-01-2023";
        NoteDate noteDate = new NoteDate(idOwner, content, date);
        NoteBuilderDate builder = new NoteBuilderDate();

        //when
        builder.setID_owner(idOwner);
        builder.setText(content);
        builder.setDate(date);

        //then
        assertEquals(builder.getResult().toString(), noteDate.toString());
    }
}
