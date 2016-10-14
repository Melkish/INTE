package se.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandUnknownTest {

    @Test
    public void unknownCommandTest(){
        Terminal terminal = new Terminal();
        terminal.setCommandString("unknown");
        terminal.theCommandLoop();
        assertTrue(terminal.getCurrentCommand() instanceof CommandUnknown);
    }

    @Test
    public void commandCdTest(){
        Terminal terminal = new Terminal();
        Folder homeFolder = new MockedFolder("TopFolder", null);
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString("cd");
        terminal.theCommandLoop();
        assertFalse(terminal.getCurrentCommand() instanceof CommandUnknown);
    }

}