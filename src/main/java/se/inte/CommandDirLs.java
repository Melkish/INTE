package se.inte;

import java.util.ArrayList;

public class CommandDirLs extends Command {

    private Folder currentFolder;
    private ArrayList printedSubFolders = new ArrayList<Folder>();
    private ArrayList printedFiles = new ArrayList<File>();

    public void execute(Terminal terminal) {
        this.currentFolder = terminal.getCurrentFolder();

        if (terminal.getCommandString().startsWith("ls -a") || terminal.getCommandString().startsWith("dir /aa")) {
            printSubFolders();
            printFilesIncludingHidden();
        } else if (terminal.getCommandString().startsWith("ls -l") || terminal.getCommandString().startsWith("dir /v") || terminal.getCommandString().startsWith("dir /os")) {
            printLongFile();

        } else {
            printSubFolders();
            printFiles();
        }
    }

    private void printSubFolders() {
        for (Folder f : currentFolder.listSubFolders()) {
            System.out.println(f.getFolderName());
            printedSubFolders.add(f);
        }
    }
    private void printFilesIncludingHidden(){
        for(File f : currentFolder.listFiles()){
            System.out.println(f.getFileName());
            printedFiles.add(f);
        }
    }
    private void printFiles(){
        for(File f : currentFolder.listFiles()){
            if(!f.isHidden()){
                System.out.println(f.getFileName());
                printedFiles.add(f);
            }
        }
    }

    private  void printLongFile(){
        for(File f : currentFolder.listFiles()){
            if(!f.isHidden()){
                System.out.println(f.getSize() + " " + f.getFileName());
                printedFiles.add(f);
            }
        }
    }
    public ArrayList<Folder> getPrintedSubFolderList() {
        return printedSubFolders;
    }


    public ArrayList<File> getPrintedFileList() {
        return printedFiles;
    }

}
