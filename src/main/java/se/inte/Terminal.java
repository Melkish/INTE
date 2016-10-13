package se.inte;

public class Terminal {

    String commandString;
    Folder currentFolder;

    public Terminal() {

    }

    public static void main (String[] args){
        Terminal terminal = new Terminal();
        terminal.theCommandLoop();
    }

    public void theCommandLoop() {
        while(!commandString.equalsIgnoreCase("quit")) {
            Command command = new Command();
            command.execute(this);
            command.executeCommand(this);
        }
    }

    public Folder getHomeFolder(){
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
