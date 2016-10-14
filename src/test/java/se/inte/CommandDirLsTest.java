package se.inte;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class CommandDirLsTest {

    private Folder homeFolder;
    private Folder subFolder1;
    private Folder subFolder2;
    private Folder subFolder3;
    private Terminal terminal;

    @Before
    public void before(){
        homeFolder = new MockedFolder("topfolder", null);
        subFolder1 = homeFolder.createSubFolder("subfolder1");
        subFolder2 = homeFolder.createSubFolder("subfolder2");
        subFolder3 = homeFolder.createSubFolder("subfolder3");
        terminal = new Terminal();
    }

    @Test
    public void commandDirPrintsSubFoldersTest(){
        terminal.setCommandString("dir");
        terminal.setCurrentFolder(homeFolder);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2) && subFolders.contains(subFolder3));
    }

    @Test
    public void commandLsPrintsSubFoldersTest(){
        terminal.setCommandString("ls");
        terminal.setCurrentFolder(homeFolder);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2) && subFolders.contains(subFolder3));
    }
}
