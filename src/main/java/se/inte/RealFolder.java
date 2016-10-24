package se.inte;

import java.util.ArrayList;
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

        return null;
    }

    @Override
    public String getFolderName() {
        return null;
    }

    @Override
    public Folder getParentFolder() {
        return null;
    }

    @Override
    public void setFolderName(String newName) {

    }

    @Override
    public File createFile(String folderName, boolean hidden, int size) {
        return null;
    }

    @Override
    public List<File> listFiles() {
        return null;
    }
}
