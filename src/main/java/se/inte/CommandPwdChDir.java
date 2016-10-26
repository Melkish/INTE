package se.inte;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Emma on 2016-10-17.
 */

public class CommandPwdChDir extends Command {

    private Folder currentFolder;
    private ArrayList<Folder> folderPath = new ArrayList<>();
    private String path;

    @Override
    public void execute(Terminal terminal){
        this.currentFolder = terminal.currentFolder;

        while (currentFolder.getParentFolder() != null){
            folderPath.add(currentFolder);
            currentFolder = currentFolder.getParentFolder();
        }
        folderPath.add(currentFolder);
        Collections.reverse(folderPath);
        path = "";
        if (terminal.getCommandString().startsWith("chdir")){
            for (Folder f : folderPath){
                path = path + "\\" + f.getFolderName();
            }
        } else if (terminal.getCommandString().startsWith("pwd")) {
            for (Folder f : folderPath) {
                path = path + "/" + f.getFolderName();
            }
        }
    }

    public String getPath(){
        return path;
    }
}
