package se.inte;

import java.util.ArrayList;
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
        homeFolderPath = homeFolderPath.getFileName();
        String folderName = homeFolderPath.toString();
        homeFolder = new RealFolder(folderName, null);
        terminal.theCommandLoop();
    }

    public void theCommandLoop() {
        currentFolder = homeFolder;
        while(!(command instanceof CommandExit)) {
            command = new Command();
            commandString = Command.getCommandString(getLocation());
            commandHistory.add(commandString);
            Command subCommand = command.checkCommand(this);
            subCommand.execute(this);
            currentCommand = subCommand;
        }
    }

    private String getLocation(){
        String location;
        if (homeFolder.equals(currentFolder)){
            location = homeFolder.getFolderName() + " ";
        } else {
            location = currentFolder.getFolderName() + " " + homeFolder.getFolderName() + " ";
        }
        return location;
    }

    public ArrayList<String> getCommandHistory() {
        return commandHistory;
    }

    public void saveCommandToHistory(String commandString){
        commandHistory.add(commandString);
    }

    public Folder setCurrentFolderToHomeFolder(){
        while(currentFolder.getParentFolder()!=null){
            currentFolder = currentFolder.getParentFolder();
        }
        return currentFolder;
    }

    public void setCommandString(String commandString){
        this.commandString = commandString;
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
