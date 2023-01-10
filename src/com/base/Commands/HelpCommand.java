package com.base.Commands;

import java.util.ArrayList;
import com.base.TODOList;

public class HelpCommand extends Command {
    public String[] helpControls = {"\tTo create new note use command: \n\t\tCreate [1, if Health or 2, if Study] [Content that you want to put in your note]",
            "\tTo delete existing note use command: \n\t\tDelete [1, if from Health or 2, if from Study] [ID of the note that you want to delete]",
            "\tTo edit existing note use command: \n\t\tEdit [1, if from Health or 2, if from Study] [ID of the note that you want to edit] [New content]",
            "\tTo print all your notes use command: \n\t\tPrint",
            "\tTo print your note encoded in Base64 use command: \n\t\tPrintB64",
            "\tTo save all your notes use command: \n\t\tSave",
            "\tTo load a backup use command: \n\t\tLoad",
            "\tTo exit me use command: \n\t\tExit"
    };

    public HelpCommand(TODOList todo) {
        super(todo);
    }


    @Override
    public boolean execute() {
        for (String message :
                helpControls) {
            System.out.println(message);
        }

        return true;
    }
}