package se.inte;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDoskeyTest {

    private ArrayList <String> testCommandHistory;
    private String cmdString1;
    private MockedFolder homeFolder;
    private Terminal terminal;

    @Before
    public void before (){
        terminal = new Terminal ();
        testCommandHistory = new ArrayList<>();
    }

    @Test
    public void getCommandHistory (){
        homeFolder = new MockedFolder("HomeFolder", null);
        cmdString1 = "mkdir HomeFolder";
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString(cmdString1);
        testCommandHistory.add(cmdString1);
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertEquals(testCommandHistory, terminal.getCommandHistory());

    }
    @Test
    public void doskey (){
        cmdString1 = "doskey";
        terminal.setCommandString(cmdString1);
        Command testCommand = new CommandHistoryDoskey();
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertEquals(testCommand.getClass(), terminal.getCurrentCommand().getClass());
    }

    @Test
    public void listIsEmpty (){
        homeFolder = new MockedFolder("HomeFolder", null);
        cmdString1 = "mkdir HomeFolder";
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString(cmdString1);
        testCommandHistory.add(cmdString1);
        testCommandHistory.clear();
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        terminal.clearHistory ();
        assertEquals(testCommandHistory, terminal.getCommandHistory());

    }

}
