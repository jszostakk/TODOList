package com.base;

import java.util.ArrayList;

public class HelpCommand extends Command {
    public String[] helpControls = {"\tTo create new note use command: \n\t\tCreate [Content that you want to put in your note]",
            "\tTo delete existing note use command: \n\t\tDelete [ID of the note that you want to delete]",
            "\tTo edit existing note use command: \n\t\tEdit [ID of the note that you want to edit] [New content]",
            "\tTo print all your notes use command: \n\t\tPrint",
            "\tTo save all your notes use command: \n\t\tSave",
            "\tTo load a backup use command: \n\t\tLoad"
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