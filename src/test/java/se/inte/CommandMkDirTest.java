package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandMkDirTest {

    private Folder homeFolder;
    private Terminal terminal;

    @Before
    public void before(){
        homeFolder = new MockedFolder("HomeFolder", null);
        terminal = new Terminal();

    }


}