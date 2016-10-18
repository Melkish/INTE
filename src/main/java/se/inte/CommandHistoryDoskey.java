package se.inte;

import java.util.ArrayList;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDoskey extends Command {

    private String commandString;
    private Terminal terminal;
    private ArrayList<String> commandHistory = new ArrayList<>();


    public void execute (Terminal terminal) {
        this.terminal = terminal;
        this.commandString = terminal.getCommandString();

    }

    public void printHistory (){
            for (int i = 0; i < terminal.getCommandHistory().size(); i++ ){
                System.out.println(terminal.getCommandHistory().get(i));
        }
    }

    public void saveCommandToHistory (String commandString){
        commandHistory.add (commandString);
    }

    public ArrayList getCommandHistory(){

        if (commandHistory.isEmpty()){
            return null;
        }
        return commandHistory;
    }





}
