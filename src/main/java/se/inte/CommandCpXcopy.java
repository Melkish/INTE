package se.inte;


/**
 * Created by Maria on 2016-10-17.
 */

public class CommandCpXcopy extends Command {

    private String commandString;
    private Folder currentFolder;
    private String folderToBeCopiedString;
    private String newFolderString;
    private Folder copiedFolder;


    public void execute(Terminal terminal) {
        this.currentFolder = terminal.getCurrentFolder();
        this.commandString = terminal.getCommandString();

        String restOfCommand = commandString.substring(6);
        String[] folderName = restOfCommand.split(" ");
        folderToBeCopiedString = folderName[0];
        newFolderString = folderName[1];

        for (Folder f : currentFolder.listSubFolders()){
            if (f.getFolderName().equalsIgnoreCase(folderToBeCopiedString)) {
                copiedFolder = f;
                copiedFolder.setFolderName(newFolderString);
            }
        } if (copiedFolder == null) {
            System.out.print("The folder " + folderToBeCopiedString + " does not exist.");
        }
    }
    public String getOriginalFolderName () {
        return folderToBeCopiedString;
    }

    public Folder getCopiedFolder(){
        return copiedFolder;
    }
}
