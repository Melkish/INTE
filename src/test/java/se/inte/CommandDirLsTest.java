package se.inte;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class CommandDirLsTest {

    private Folder currentFolder;
    private Folder subFolder1;
    private Folder subFolder2;
    private Folder subFolder3;
    private Terminal terminal;

    @Before
    public void before(){
        currentFolder = new MockedFolder("user", null);
        subFolder1 = currentFolder.createSubFolder("documents");
        subFolder2 = currentFolder.createSubFolder("images");
        subFolder3 = currentFolder.createSubFolder("downloads");
        terminal = new Terminal();
    }


/*
    @Test
    public void getFolderNameTest() {
        CommandDirLs commandDirLs = new CommandDirLs(currentFolder);
        assertEquals(currentFolder, commandDirLs.getCurrentFolder());
    }

    @Test
    public void listOfSubFoldersTest(){
        CommandDirLs commandDirLs = new CommandDirLs(currentFolder);
        List<Folder> subFolders = commandDirLs.getSubFolders();
        assertTrue(subFolders.contains(subFolder1));
        assertTrue(subFolders.contains(subFolder2));
        assertTrue(subFolders.contains(subFolder3));
    }
    */

    @Test
    public void commandDirPrintsSubFoldersTest(){
        terminal.setCommandString("dir");
        terminal.setCurrentFolder(currentFolder);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2) && subFolders.contains(subFolder3));
    }

    @Test
    public void commandLsPrintsSubFoldersTest(){
        terminal.setCommandString("ls");
        terminal.setCurrentFolder(currentFolder);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2) && subFolders.contains(subFolder3));
    }
}
