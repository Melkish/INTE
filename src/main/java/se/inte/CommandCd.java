package se.inte;

public class CommandCd {

    private Folder currentFolder;

    public CommandCd(Folder currentFolder) {
        this.currentFolder = currentFolder;
    }

    public Folder getHomeFolder(){
        while(currentFolder.getParentFolder()!=null){
            currentFolder = currentFolder.getParentFolder();
        }
        return currentFolder;
    }

    public Folder getParentFolder(){
        currentFolder = currentFolder.getParentFolder();
        return currentFolder;
    }

    public Folder getSubFolderByName(String folderToBeFound){
        for (Folder f : currentFolder.listSubFolders()){
            if (f.getFolderName().equalsIgnoreCase(folderToBeFound)){
                return f;
            }
        }
        System.out.println("Error no such file or directory");
        return null;
    }

}
