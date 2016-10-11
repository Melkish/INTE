package se.inte;

import java.util.List;

/**
 * Created by Melke on 11/10/16.
 */
public class MockedFolder implements Folder {
    @Override
    public Folder createSubFolder(String folderName) {
        return null;
    }

    @Override
    public List<Folder> listSubFolders() {
        return null;
    }
}
