package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerminalTest {

    Terminal terminal;
    Folder currentFolder;

    @Before
    public void before(){
        terminal = new Terminal();
        currentFolder = new MockedFolder("Home", null);
    }

    @Test
    public void terminalCreatedTest(){
        assertEquals(terminal, terminal.getTerminal());
    }

    @Test
    public void theCommandLoopTest(){
        terminal.setCommandString("cd");
        assertEquals("cd", terminal.getCommandString());
    }

    @Test
    public void currentFolderTest(){
        terminal.setCurrentFolder(currentFolder);
        assertEquals(currentFolder, terminal.getCurrentFolder());
    }


}