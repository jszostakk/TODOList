package com.base.Tags;

import java.util.ArrayList;
import com.base.Notes.*;

public class TagHealth extends Tag {
    private static TagHealth instance;
    private NoteBuilderDate noteBuilderDate;
    private NoteBuilderWithoutDate noteBuilderWithoutDate;


    public static TagHealth getInstance() {
        if (instance == null) {
            instance = new TagHealth();
        }
        return instance;
    }
}
