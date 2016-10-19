package se.inte;

import java.util.ArrayList;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDoskey extends Command {

    private Terminal terminal;
    private boolean hasPrinted = false;

    public void execute (Terminal terminal) {
        this.terminal = terminal;
        printHistory(terminal.getCommandHistory());

    }


    public void printHistory (ArrayList listToPrint) {
        if (!listToPrint.isEmpty()) {
            for (int i = 0; i < listToPrint.size(); i++) {
                System.out.println(listToPrint.get(i) + "command> ");
                hasPrinted = true;
            }
        }else {
            System.out.print ("History is empty");
        }
    }

}
