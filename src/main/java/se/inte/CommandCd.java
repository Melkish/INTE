package se.inte;

public class CommandCd extends Command{

    private Folder currentFolder;
    private String commandString;

    @Override
    public void execute(Terminal terminal){
        this.currentFolder = terminal.getCurrentFolder();
        this.commandString = terminal.getCommandString();

        if(commandString.equalsIgnoreCase("cd")){
            terminal.getHomeFolder();
        } else if (commandString.equalsIgnoreCase("cd ..")){
            if(currentFolder.getParentFolder() != null){
                terminal.setCurrentFolder(currentFolder.getParentFolder());
            }
        } else if (commandString.startsWith("cd ")){
            String dirName = getDirName(commandString);
            for (Folder f : currentFolder.listSubFolders()){
                if (f.getFolderName().equalsIgnoreCase(dirName)){
                    terminal.setCurrentFolder(f);
                    return;
                }
            }
            System.out.println("No directory with name " + dirName);
        }
    }

    private String getDirName(String fullString){
        return fullString.substring(3);
    }

    public Folder getHomeFolder(){
        while(currentFolder.getParentFolder()!=null){
            currentFolder = currentFolder.getParentFolder();
        }
        return currentFolder;
    }

    public Folder getCurrentFolder(){
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

    public String getCommandName(){
        return "cd";
    }

}
