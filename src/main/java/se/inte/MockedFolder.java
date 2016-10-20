package se.inte;

import java.util.*;

public class MockedFolder implements Folder {

    private String folderName;
    private ArrayList<Folder> subFolderList = new ArrayList<>();
    private Folder parentFolder;
    private ArrayList<File> fileList = new ArrayList<>();

    public MockedFolder(String folderName, Folder parentFolder) {
        this.folderName = folderName;
        this.parentFolder = parentFolder;
    }

    @Override
    public Folder createSubFolder(String folderName) {
        Folder subFolder = new MockedFolder(folderName, this);
        subFolderList.add(subFolder);
        return subFolder;
    }
    public Folder copyFolder(String folderName){
        Folder copyFolder = new MockedFolder(folderName, this);
        subFolderList.add(copyFolder);
        return copyFolder;
    }

    @Override
    public ArrayList<Folder> listSubFolders() {
        return subFolderList;
    }

    @Override
    public ArrayList<File> listFiles(){
        return fileList;
    }

    @Override
    public String getFolderName(){
        return this.folderName;
    }

    @Override
    public Folder getParentFolder(){
        return parentFolder;
    }

    @Override
    public void setFolderName(String newName){
        this.folderName = newName;
    }

    @Override
    public File createFile(String fileName, boolean hidden, int size){
        File file = new MockedFile(fileName, this, hidden, size);
        fileList.add(file);
        return file;
    }
}
