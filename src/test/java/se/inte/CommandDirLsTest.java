package se.inte;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class CommandDirLsTest {

    private Folder topFolder;
    private Folder subFolder1;
    private Folder subFolder2;
    private Folder subFolder3;
    private Terminal terminal;

    @Before
    public void before(){
        topFolder = new MockedFolder("topfolder", null);
        subFolder1 = topFolder.createSubFolder("subfolder1");
        subFolder2 = topFolder.createSubFolder("subfolder2");
        subFolder3 = topFolder.createSubFolder("subfolder3");
        terminal = new Terminal();
    }

    @Test
    public void commandDirPrintsSubFoldersTest(){
        terminal.setCommandString("dir");
        terminal.setCurrentFolder(topFolder);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2) && subFolders.contains(subFolder3));
    }

    @Test
    public void commandLsPrintsSubFoldersTest(){
        terminal.setCommandString("ls");
        terminal.setCurrentFolder(topFolder);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2) && subFolders.contains(subFolder3));
    }
}
