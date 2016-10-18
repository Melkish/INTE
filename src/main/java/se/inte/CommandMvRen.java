package se.inte;

/**
 * Created by Melke on 18/10/16.
 */
public class CommandMvRen extends Command {

    private String commandStringWithoutCommand;
    private boolean nameChanged;

    public void execute(Terminal terminal){

        if (terminal.getCommandString().startsWith("mv ")){
            commandStringWithoutCommand = terminal.getCommandString().substring(3);
        } else {
            commandStringWithoutCommand = terminal.getCommandString().substring(4);
        }

        String[] bothNames = commandStringWithoutCommand.split(" ");
        String oldName = bothNames[0];
        String newName = bothNames[1];

        for (Folder f : terminal.getCurrentFolder().listSubFolders()){
            if (f.getFolderName().equalsIgnoreCase(oldName)){
                f.setFolderName(newName);
                nameChanged = true;
            }
        }
        if(!nameChanged){
            System.out.println("No folder with name " + oldName);
        }
    }

    public boolean isNameChanged(){
        return nameChanged;
    }
}
