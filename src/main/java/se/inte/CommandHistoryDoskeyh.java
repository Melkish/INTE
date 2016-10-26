package se.inte;

import java.util.ArrayList;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDosKeyH extends Command {

        @Override
        public void execute (Terminal terminal) {
        printHistory(terminal.getCommandHistory());

    }


    public void printHistory (ArrayList listToPrint) {
        if (!listToPrint.isEmpty()) {
            System.out.println("commmand history list ");
            for (int i = 0; i < listToPrint.size(); i++) {
                System.out.println((i+1) +" " + listToPrint.get(i));
            }
        }
    }

}
