package se.inte;

import java.util.ArrayList;

public class CommandDirLs extends Command{

    private Folder currentFolder;
    private ArrayList printedSubFolders = new ArrayList<Folder>();

    public void execute(Terminal terminal){
        this.currentFolder = terminal.getCurrentFolder();
        printSubFolders();

    }

    public void printSubFolders() {
        for(Folder f : currentFolder.listSubFolders()){
            System.out.println(f.getFolderName());
            printedSubFolders.add(f);
        }
    }

    public ArrayList<Folder> getPrintedSubFolderList(){
        return printedSubFolders;
    }
}
