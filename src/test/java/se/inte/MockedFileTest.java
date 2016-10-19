package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melke on 19/10/16.
 */
public class MockedFileTest {

    Folder homeFolder;
    File testFile;

    @Before
    public void before(){
        homeFolder = new MockedFolder("homeFolder", null);
    }

    @Test
    public void fileNameTest(){
        testFile = homeFolder.createFile("testFile", false, 10);
        assertEquals("testFile", testFile.getFileName());
    }

    @Test
    public void isHiddenTest(){
        testFile = homeFolder.createFile("testFile", false, 10);
        assertFalse(testFile.isHidden());
    }

    @Test
    public void isHiddenIsTrueTest(){
        testFile = homeFolder.createFile("testFile", true, 10);
        assertTrue((testFile.isHidden()));
    }

    @Test
    public void fileSizeTest(){
        testFile = homeFolder.createFile("testFile", true, 10);
        assertEquals(10, testFile.getSize());
    }

    @Test
    public void parentFolderTest(){
        testFile = homeFolder.createFile("testFile", false, 10);
        assertEquals(homeFolder, testFile.getParentFolder());
    }

}