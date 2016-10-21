package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melke on 18/10/16.
 */
public class CommandMvRenTest {

    private Folder homeFolder;
    private Folder subFolder;
    private Terminal terminal;
    private Command command;

    @Before
    public void before(){
        homeFolder = new MockedFolder("homeFolder", null);
        subFolder = homeFolder.createSubFolder("subFolder");
        terminal = new Terminal();
    }

    @Test
    public void commandMvTest(){
        terminal.setCommandString("mv subFolder newName");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertEquals("newName", subFolder.getFolderName());
    }

    @Test
    public void commandRenTest(){
        terminal.setCommandString("ren subFolder newName");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertEquals("newName", subFolder.getFolderName());
    }

    @Test
    public void folderNotExistingTest(){
        terminal.setCommandString("mv notExistingFolder newName");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        assertFalse(((CommandMvRen) command).isNameChanged());
    }

}