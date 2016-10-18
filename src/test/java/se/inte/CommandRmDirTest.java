package se.inte;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Olivia on 2016-10-18.
 */
public class CommandRmDirTest {
    private Terminal terminal;
    private Folder homeFolder;
    private Folder subFolder;
    private Command command;

    @Before
    public void before(){
        homeFolder = new MockedFolder("HomeFolder", null);
        subFolder = homeFolder.createSubFolder("subfolder");
        terminal = new Terminal();
    }

    @Test
    public void commandRmDirTest(){
        terminal.setCommandString("rmdir subfolder");
        terminal.setCurrentFolder(homeFolder);
        terminal.theCommandLoop();
        List<Folder> subFolders = homeFolder.listSubFolders();
        assertFalse(subFolders.contains(subFolder));
    }
    @Test
    public void folderNotExistTest(){
        terminal.setCommandString("rmdir nonExistingFolder");
        terminal.setCurrentFolder(homeFolder);
        terminal.theCommandLoop();
        command = terminal.getCurrentCommand();
        assertFalse(((CommandRmdir) command).isFolderRemoved());
    }
}
