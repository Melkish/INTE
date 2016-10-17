package se.inte;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Emma on 2016-10-17.
 */

public class CommandPwdChdir extends Command {

    private Folder currentFolder;
    private ArrayList<Folder> folders = new ArrayList<>();
    private String path;

    @Override
    public void execute(Terminal terminal){
        this.currentFolder = terminal.currentFolder;

        while (currentFolder.getParentFolder() != null){
            folders.add(currentFolder);
            currentFolder = currentFolder.getParentFolder();
        }
        folders.add(currentFolder);
        Collections.reverse(folders);
        path = "";
        for (Folder f : folders){
            path = path + "/" + f.getFolderName();
        }
    }

    public String getPath(){
        return path;
    }
}
