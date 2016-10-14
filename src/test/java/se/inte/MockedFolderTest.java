package se.inte;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class MockedFolderTest {

    private Folder myFolder;

    @Before
    public void before(){
        myFolder = new MockedFolder("homeFolder", null);
    }

    @Test
    public void folderNameTest(){
        assertEquals("homeFolder", myFolder.getFolderName());
    }

    @Test
    public void addFolderTest(){
        Folder subFolder = myFolder.createSubFolder("subfolder");
        assertEquals("subfolder", subFolder.getFolderName());
    }

    @Test
    public void listFoldersTest(){
        Folder subFolder1 = myFolder.createSubFolder("subfolder1");
        Folder subfolder2 = myFolder.createSubFolder("subfolder2");
        List<Folder> subFolders = myFolder.listSubFolders();
        assertTrue(subFolders.contains(subFolder1));
        assertTrue(subFolders.contains(subfolder2));
    }

    @Test
    public void parentFolderTest(){
        Folder subFolder = myFolder.createSubFolder("subfolder");
        assertEquals(myFolder, subFolder.getParentFolder());
    }


}