package se.inte;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandDirLsTest {

    private static MyFile file = new MyFile();

    @Test
    public void getFileTest() {
        CommandDirLs commandDirLs = new CommandDirLs(file);
        assertEquals(file, commandDirLs.getFile());
    }
}
