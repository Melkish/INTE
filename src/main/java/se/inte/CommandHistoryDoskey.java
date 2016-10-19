package se.inte;

import java.util.ArrayList;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDoskey extends Command {

    public void execute (Terminal terminal) {
        printHistory(terminal.getCommandHistory());
    }


    public void printHistory (ArrayList listToPrint) {
        if (!listToPrint.isEmpty()) {
            for (int i = 0; i < listToPrint.size(); i++) {
                System.out.println(listToPrint.get(i) + "command> ");
            }
        }
    }

}
