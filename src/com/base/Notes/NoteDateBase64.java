package com.base.Notes;

import java.util.Base64;

public class NoteDateBase64 extends NoteDate{
    public NoteDateBase64(int id, String text, String date) {
        super(id, text, date);
    }

    public String getText() {
        return Base64.getEncoder().encodeToString(this.text.getBytes());
    }
}
