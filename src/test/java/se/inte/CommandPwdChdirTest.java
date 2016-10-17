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
    private Folder subfolder;

    @Before
    public void before(){
        terminal = new Terminal();
        homeFolder = new MockedFolder("homeFolder", null);
        subfolder = new MockedFolder("subFolder", homeFolder);
    }


    @Test
    public void PwdChdirTest(){
        terminal.setCommandString("chdir");
        terminal.setCurrentFolder(subfolder);
        terminal.theCommandLoop();
        Command command = terminal.getCurrentCommand();
        String correctPath = ((CommandPwdChdir) command).getPath();
        String path = "/homeFolder/subFolder";
        assertEquals(path, correctPath);
    }
}