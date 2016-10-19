package se.inte;

import java.util.ArrayList;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDoskeyh extends Command {

    private Terminal terminal;

    public void execute (Terminal terminal) {
        this.terminal = terminal;
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
