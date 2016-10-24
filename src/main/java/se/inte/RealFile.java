package se.inte;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Melke on 21/10/16.
 */
public class RealFile implements File {

    private String fileName;
    private Folder parentFolder;
    private boolean hidden;
    private int size;
    private Path path;
    private ArrayList <Folder> filePath = new ArrayList <> ();

    public RealFile(String fileName, Folder parentFolder, boolean hidden, int size) {
        this.fileName = fileName;
        this.parentFolder = parentFolder;
        this.hidden = hidden;
        this.size = size;
    }

    private Path createPath(){
            File currentFile = this;
            String path;
            Folder currentFolder = currentFile.getParentFolder();
            while (currentFolder.getParentFolder() != null) {
                filePath.add(currentFolder);
                currentFolder = currentFolder.getParentFolder();
            }
            Collections.reverse(filePath);
            path = "";
            for (Folder f : filePath) {
                path = path + "/" + f.getFolderName();
            }
            path = path + "/" + fileName;
            Path funPath = Paths.get(path);
            return funPath;

    }
    @Override
    public Path getPath (){
        return createPath ();
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public Folder getParentFolder() {
        return parentFolder;
    }

    @Override
    public void setFileName(String newName) {

    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
