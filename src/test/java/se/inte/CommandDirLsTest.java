package se.inte;

import org.junit.*;

import java.io.File;

import static org.junit.Assert.*;

public class CommandDirLsTest {

    private static File file = new File("pathname");

    @Test
    public void getFileTest() {
        CommandDirLs commandDirLs = new CommandDirLs(file);
        assertEquals(file, commandDirLs.getFile());
    }
}
