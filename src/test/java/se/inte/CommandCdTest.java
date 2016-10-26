package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandCdTest {

    private Folder homeFolder;
    private Folder subFolder1;
    private Folder subFolder2;
    private Folder subFolder3 ;
    private Terminal terminal;

    @Before
    public void before(){
        homeFolder = new MockedFolder("TopFolder", null);
        subFolder1 = homeFolder.createSubFolder("subfolder1");
        subFolder2 = subFolder1.createSubFolder("subfolder2");
        subFolder3 = subFolder2.createSubFolder("subfolder3");
        terminal = new Terminal();

    }

    @Test
    public void commandCdTest(){
        terminal.setCommandString("cd");
        terminal.setCurrentFolder(subFolder3);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(homeFolder, testFolder);
    }

    @Test public void commandCdDotDotTest(){
        terminal.setCommandString("cd ..");
        terminal.setCurrentFolder(subFolder3);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(subFolder2, testFolder);
    }

    @Test public void commandCdDotDotFromHomeTest(){
        terminal.setCommandString("cd ..");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(homeFolder, testFolder);
    }

    @Test public void commandCdDirNameTest(){
        terminal.setCommandString("cd subfolder2");
        terminal.setCurrentFolder(subFolder1);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(subFolder2, testFolder);
    }

    @Test public void commandCdWrongDirNameTest(){
        terminal.setCommandString("cd poop");
        terminal.setCurrentFolder(subFolder1);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        Folder testFolder = terminal.getCurrentFolder();
        assertEquals(subFolder1, testFolder);
    }

}