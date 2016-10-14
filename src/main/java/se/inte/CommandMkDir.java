package se.inte;

public class CommandMkDir extends Command {

    public void execute(Terminal terminal){
        Folder currentFolder = terminal.getCurrentFolder();
        String dirName = terminal.getCommandString().substring(6);
        currentFolder.createSubFolder(dirName);
    }
}
