package se.inte;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Olivia on 2016-10-18.
 */
public class CommandRmdir extends Command {

    private boolean folderRemoved;

    public void execute(Terminal terminal) {

        Folder currentFolder = terminal.getCurrentFolder();
        List<Folder> subFolderList = currentFolder.listSubFolders();
        String commandString = terminal.getCommandString();
        String folderToBeRemoved = commandString.substring(6);

        Iterator<Folder> i = subFolderList.iterator();
        while (i.hasNext()) {
            Folder f = i.next();
            if (f.getFolderName().equalsIgnoreCase(folderToBeRemoved)) {
                i.remove();
                folderRemoved = true;
            }
        }
        if (!folderRemoved) {
            System.out.println("Folder " + folderToBeRemoved + (" does not exisit."));
        }
    }

    public boolean isFolderRemoved(){
        return folderRemoved;
    }


}
