package se.inte;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.*;
import static java.lang.Math.toIntExact;
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
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public Folder getParentFolder() {
        return parentFolder;
    }

    @Override
    public void setFileName(String newName) {
        this.fileName = newName;
    }

    @Override
    public boolean isHidden() {
        Path path = createPath();
        try{
            hidden = Files.isHidden(path);
        } catch (IOException e) {
            System.out.println("Error");
        }
        return hidden;
    }

    @Override
    public int getSize() {
        Path path = createPath();
        try{
            Long sizeAsLong = Files.size(path);
            size = toIntExact(sizeAsLong);
        } catch (IOException e){
            System.out.println("Error");
        }
        return size;
    }
}
