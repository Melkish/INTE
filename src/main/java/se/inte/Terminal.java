package se.inte;

import java.util.ArrayList;

public class Terminal {

    String commandString;
    Folder currentFolder;
    Command currentCommand;
    ArrayList<String> commandHistory  = new ArrayList<>();


    public Terminal() {
    }
    public static void main (String[] args){
        Terminal terminal = new Terminal();
        terminal.theCommandLoop();
    }

    public void theCommandLoop() {
        //while(!(command instanceof CommandExit)) {
        int i = 1;
        while(i != 0){
            i = i - 1;
            Command command = new Command();
            Command subCommand = command.executeCommand(this);
            subCommand.execute(this);
            currentCommand = subCommand;
        }

    }

    public ArrayList<String> getCommandHistory() {
        return commandHistory;
    }
    /*
    public void clearHistory (){
        commandHistory.clear();
    }
*/
    public Folder setCurrentFolderToHomeFolder(){
        while(currentFolder.getParentFolder()!=null){
            currentFolder = currentFolder.getParentFolder();
        }
        return currentFolder;
    }


    public void setCommandString(String commandString){
        this.commandString = commandString;
        commandHistory.add(commandString);
    }

    public String getCommandString(){
        return commandString;
    }

    public Command getCurrentCommand(){
        return currentCommand;
    }

    public Terminal getTerminal(){
        return this;
    }

    public void setCurrentFolder(Folder folder){
        currentFolder = folder;
    }

    public Folder getCurrentFolder(){
        return currentFolder;
    }
}
