package se.inte;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandMkDirTest {

    private Folder homeFolder;
    private Terminal terminal;

    @Before
    public void before(){
        homeFolder = new MockedFolder("HomeFolder", null);
        terminal = new Terminal();

    }

    @Test
    public void commandMkDirTest(){
        terminal.setCommandString("mkdir subfolder");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        terminal.setCommandString("exit");
        List<Folder> subFolderList = homeFolder.listSubFolders();
        assertEquals("subfolder", subFolderList.get(0).getFolderName());
    }


}