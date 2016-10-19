package se.inte;

import java.util.ArrayList;

public class CommandDirLs extends Command{

    private Folder currentFolder;
    private ArrayList printedSubFolders = new ArrayList<Folder>();

    public void execute(Terminal terminal){
        this.currentFolder = terminal.getCurrentFolder();

        if (terminal.getCommandString().startsWith("ls -a") || terminal.getCommandString().startsWith("dir /aa")){

        } else if (terminal.getCommandString().startsWith("ls -l") || terminal.getCommandString().startsWith("dir /v") || terminal.getCommandString().startsWith("dir /os")){

        } else {
            printContentNormal();
        }
    }

    public void printContentNormal() {
        for(Folder f : currentFolder.listSubFolders()){
            System.out.println(f.getFolderName());
            printedSubFolders.add(f);
        }
    }

    public ArrayList<Folder> getPrintedSubFolderList(){
        return printedSubFolders;
    }
}
