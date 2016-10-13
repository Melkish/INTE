package se.inte;

import java.util.List;

public class CommandDirLs extends Command{

    private Folder currentFolder;

    public CommandDirLs(Folder currentFolder) {
        this.currentFolder = currentFolder;
    }

    public Folder getCurrentFolder() {
        return this.currentFolder;
    }

    public List<Folder> getSubFolders() {
        return currentFolder.listSubFolders();
    }

    public void printSubFolders() {
        for(Folder f : currentFolder.listSubFolders()){
            System.out.println(f.getFolderName());
        }
    }
}
