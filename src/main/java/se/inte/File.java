package se.inte;

import java.nio.file.*;
import java.util.List;

/**
 * Created by Melke on 11/10/16.
 */
public interface File {

    String getFileName();
    Folder getParentFolder();
    void setFileName(String newName);
    boolean isHidden();
    int getSize();
}
