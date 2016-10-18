package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Emma on 2016-10-17.
 */
public class CommandPwdChdirTest {

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
    public void ChdirTest(){
        terminal.setCommandString("chdir");
        terminal.setCurrentFolder(subFolder2);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        String correctPath = ((CommandPwdChdir) command).getPath();
        String path = "/homeFolder/subFolder1/subFolder2";
        assertEquals(path, correctPath);
    }
 
    @Test
    public void PwdTest(){
        terminal.setCommandString("pwd");
        terminal.setCurrentFolder(subFolder1);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        String correctPath = ((CommandPwdChdir) command).getPath();
        String path = "/homeFolder/subFolder1";
        assertEquals(path, correctPath);
    }
}