package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Emma on 2016-10-17.
 */
public class CommandPwdChDirTest {

    private Terminal terminal;
    private Folder homeFolder;
    private Folder subFolder1;
    private Folder subFolder2;

    @Before
    public void before(){
        terminal = new Terminal();
        homeFolder = new MockedFolder("homeFolder", null);
        subFolder1 = new MockedFolder("subFolder1", homeFolder);
        subFolder2 = new MockedFolder("subFolder2", subFolder1);
    }


    @Test
    public void ChDirTest(){
        terminal.setCommandString("chdir");
        terminal.setCurrentFolder(subFolder2);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        String correctPath = ((CommandPwdChDir) command).getPath();
        String path = "\\homeFolder\\subFolder1\\subFolder2";
        assertEquals(path, correctPath);
    }

    @Test
    public void PwdTest(){
        terminal.setCommandString("pwd");
        terminal.setCurrentFolder(subFolder1);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        String correctPath = ((CommandPwdChDir) command).getPath();
        String path = "/homeFolder/subFolder1";
        assertEquals(path, correctPath);
    }

    @Test
    public void NoParentFoldersTest(){
        terminal.setCommandString("pwd");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        String correctPath = ((CommandPwdChDir) command).getPath();
        String path = "/homeFolder";
        assertEquals(path, correctPath);
    }
}