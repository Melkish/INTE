package se.inte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.nio.file.*;

/**
 * Created by Melke on 21/10/16.
 */
public class RealFolder implements Folder {

    private String folderName;
    private ArrayList<Folder> subFolderList = new ArrayList<>();
    private Folder parentFolder;
    private ArrayList<File> fileList = new ArrayList<>();
    private ArrayList<Folder> folderPath = new ArrayList<>();

    public RealFolder(String folderName, Folder parentFolder) {
        this.folderName = folderName;
        this.parentFolder = parentFolder;
    }

    @Override
    public Folder createSubFolder(String folderName) {
        return null;
    }

    @Override
    public List<Folder> listSubFolders() {
        //TODO implement functionality
        return subFolderList;
    }

    private Path createPath(){
        Folder currentFolder = this;
        String path;
        while (currentFolder.getParentFolder() != null){
            folderPath.add(currentFolder);
            currentFolder = currentFolder.getParentFolder();
        }
        folderPath.add(currentFolder);
        Collections.reverse(folderPath);
        path = "";
        for (Folder f : folderPath) {
            path = path + "/" + f.getFolderName();
        }
        Path funPath = Paths.get(path);
        return funPath;
    }

    @Override
    public String getFolderName() {
        return folderName;
    }

    @Override
    public Folder getParentFolder() {
        return parentFolder;
    }

    @Override
    public void setFolderName(String newName) {
        this.folderName = newName;
    }

    @Override
    public File createFile(String folderName, boolean hidden, int size) {
        return null;
    }

    @Override
    public List<File> listFiles() {
        //TODO fix functionality
        return fileList;
    }
}
