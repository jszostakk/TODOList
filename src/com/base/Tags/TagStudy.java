package com.base.Tags;

import java.util.ArrayList;
import com.base.Notes.*;

public class TagStudy extends Tag{
    private static TagStudy instance;
    private NoteBuilderDate noteBuilderDate;
    private NoteBuilderWithoutDate noteBuilderWithoutDate;


    public static TagStudy getInstance() {
        if (instance == null) {
            instance = new TagStudy();
        }
        return instance;
    }
}
