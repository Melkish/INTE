package se.inte;

import java.util.ArrayList;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDoskeyh extends Command {

        @Override
        public void execute (Terminal terminal) {
        printHistory(terminal.getCommandHistory());

    }


    public void printHistory (ArrayList listToPrint) {
        if (!listToPrint.isEmpty()) {
            for (int i = 0; i < listToPrint.size(); i++) {
                System.out.println( "commmand history list "+  (i+1) +" " + listToPrint.get(i));
            }
        }
    }

}
