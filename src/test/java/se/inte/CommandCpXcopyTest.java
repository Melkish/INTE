package se.inte;

/**
 * Created by Maria on 2016-10-17.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;


public class CommandCpXcopyTest {

    private Folder subFolder1;
    private Folder subFolder2;
    private Terminal terminal;
    private Folder homeFolder;
    private Folder newFolder;

    @Before
    public void before() {
        homeFolder = new MockedFolder("topfolder", null);
        subFolder1 = homeFolder.createSubFolder("subfolder1");
        terminal = new Terminal();
    }
    @Test
    public void commandCpCopyDirectoryTest(){
        terminal.setCommandString("cp -r subfolder1 newFolder");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        newFolder = ((CommandCpXcopy) command).getCopiedFolder();
        assertEquals("newFolder", newFolder.getFolderName());
    }

    //TODO create test to check if the first folders name is also changed
    











}
