package se.inte;

import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.*;

public class Terminal {

    static Folder homeFolder;
    String commandString;
    Folder currentFolder;
    Command currentCommand;
    ArrayList<String> commandHistory  = new ArrayList<>();
    Command command;

    public Terminal() {
    }

    public static void main (String[] args){
        Terminal terminal = new Terminal();
        Path homeFolderPath = Paths.get(System.getProperty("user.home"));
        String folderName = homeFolderPath.toString();
        homeFolder = new RealFolder(folderName, null);
        terminal.theCommandLoop();


    }

    public void theCommandLoop() {
        currentFolder = homeFolder;
        while(!(command instanceof CommandExit)) {
            Scanner scanner = new Scanner(System.in);
            commandString = scanner.nextLine();
            scanner.close();
            command = new Command();
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

    public void setCommand(Command command){
        this.currentCommand = command;
    }

    public void setCurrentFolder(Folder folder){
        currentFolder = folder;
    }

    public Folder getCurrentFolder(){
        return currentFolder;
    }
}
