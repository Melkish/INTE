package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandCdTest {

    private Folder currentFolder;
    private Folder subFolder1;
    private Folder subFolder2;
    private Folder subFolder3;

    @Before
    public void before(){
        currentFolder = new MockedFolder("My_folder", null);
        subFolder1 = currentFolder.createSubFolder("documents");
        subFolder2 = subFolder1.createSubFolder("images");
        subFolder3 = subFolder2.createSubFolder("downloads");
    }

    @Test
    public void homeFolderTest(){
        CommandCd commandCd = new CommandCd(subFolder3);
        assertEquals(currentFolder, commandCd.getHomeFolder());
    }

    @Test
    public void parentFolderTest(){
        CommandCd commandCd = new CommandCd(subFolder1);
        assertEquals(currentFolder, commandCd.getParentFolder());
    }

    @Test
    public void subFolderTest(){
        CommandCd commandCd = new CommandCd(currentFolder);
        assertEquals(subFolder1, commandCd.getSubFolderByName("documents"));
    }

}