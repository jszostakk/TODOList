package com.base.Notes;

import java.util.Base64;

public class NoteWithoutDateBase64 extends NoteWithoutDate{

    public NoteWithoutDateBase64(int id, String text) {
        super(id, text);
    }

    public String getText() {
        return Base64.getEncoder().encodeToString(this.text.getBytes());
    }
}
