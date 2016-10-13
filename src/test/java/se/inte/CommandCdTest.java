package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandCdTest {

    private Folder currentFolder;
    private Folder subFolder1;
    private Folder subFolder2;
    private Folder subFolder3;
    private Terminal terminal;
    private String commandString = null;
    private Command command;

    @Before
    public void before(){
        currentFolder = new MockedFolder("My_folder", null);
        subFolder1 = currentFolder.createSubFolder("documents");
        subFolder2 = subFolder1.createSubFolder("images");
        subFolder3 = subFolder2.createSubFolder("downloads");
        terminal = new Terminal();
        command = new Command();

    }

    @Test
    public void homeFolderTest(){
        CommandCd commandCd = new CommandCd();
        assertEquals(currentFolder, commandCd.getHomeFolder());
    }

    @Test
    public void parentFolderTest(){
        CommandCd commandCd = new CommandCd();
        assertEquals(currentFolder, commandCd.getParentFolder());
    }

    @Test
    public void subFolderTest(){
        CommandCd commandCd = new CommandCd();
        assertEquals(subFolder1, commandCd.getSubFolderByName("documents"));
    }

    @Test
    public void commandCdTest(){
        terminal.setCommandString("cd");
        terminal.setCurrentFolder(subFolder3);
        terminal.theCommandLoop();
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(currentFolder, testFolder);
    }

    @Test public void commandCdDotDotTest(){
        terminal.setCommandString("cd ..");
        terminal.setCurrentFolder(subFolder3);
        terminal.theCommandLoop();
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(subFolder2, testFolder);
    }

    @Test public void commandCdDirNameTest(){
        terminal.setCommandString("cd images");
        terminal.setCurrentFolder(subFolder1);
        terminal.theCommandLoop();
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(subFolder2, testFolder);
    }

    @Test public void commandCdWrongDirNameTest(){
        terminal.setCommandString("cd poop");
        terminal.setCurrentFolder(subFolder1);
        terminal.theCommandLoop();
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(subFolder1, testFolder);
    }

}