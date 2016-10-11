package se.inte;

import org.junit.*;

import static org.junit.Assert.*;

public class MockedFolderTest {

    @Test
    public void addFolderTest(){
        Folder myFolder = new MockedFolder();
        Folder subFolder = myFolder.createSubFolder("images");
        assertTrue(myFolder.listSubFolders().contains(subFolder));
    }


}