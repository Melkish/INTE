package se.inte;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class MockedFolderTest {

    private Folder myFolder;

    @Before
    public void before(){
        myFolder = new MockedFolder("My_folder", null);
    }

    @Test
    public void folderNameTest(){
        assertEquals("My_folder", myFolder.getFolderName());
    }

    @Test
    public void addFolderTest(){
        Folder subFolder = myFolder.createSubFolder("images");
        assertEquals("images", subFolder.getFolderName());
    }

    @Test
    public void listFoldersTest(){
        Folder subFolder1 = myFolder.createSubFolder("images");
        Folder subfolder2 = myFolder.createSubFolder("documents");
        List<Folder> subFolders = myFolder.listSubFolders();
        assertTrue(subFolders.contains(subFolder1));
        assertTrue(subFolders.contains(subfolder2));
    }

    @Test
    public void parentFolderTest(){
        Folder subFolder = myFolder.createSubFolder("images");
        assertEquals(myFolder, subFolder.getParentFolder());
    }


}