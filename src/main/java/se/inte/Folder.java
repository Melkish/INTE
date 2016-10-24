package se.inte;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by Melke on 11/10/16.
 */
public interface Folder {

    Folder createSubFolder(String folderName);
    List<Folder> listSubFolders();
    String getFolderName();
    Folder getParentFolder();
    void setFolderName(String newName);
    File createFile(String folderName, boolean hidden, int size);
    List<File> listFiles();
    Path getPath();
}
