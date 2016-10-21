package se.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandUnknownTest {

    @Test
    public void unknownCommandTest(){
        Terminal terminal = new Terminal();
        terminal.setCommandString("unknown");
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertTrue(terminal.getCurrentCommand() instanceof CommandUnknown);
    }

    @Test
    public void commandCdTest(){
        Terminal terminal = new Terminal();
        Folder homeFolder = new MockedFolder("TopFolder", null);
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString("cd");
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertFalse(terminal.getCurrentCommand() instanceof CommandUnknown);
    }

}