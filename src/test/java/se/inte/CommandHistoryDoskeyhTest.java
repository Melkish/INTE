package se.inte;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * Created by Miran on 2016-10-18.
 */
public class CommandHistoryDoskeyhTest {

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
    public void getCommandHistoryTest (){
        homeFolder = new MockedFolder("HomeFolder", null);
        cmdString1 = "mkdir HomeFolder";
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString(cmdString1);
        testCommandHistory.add(cmdString1);
        terminal.theCommandLoop();
        assertEquals(testCommandHistory, terminal.getCommandHistory());

    }
    @Test
    public void cmdDoskeyhTest (){
        cmdString1 = "doskey /h";
        terminal.setCommandString(cmdString1);
        Command testCommand = new CommandHistoryDoskeyh();
        terminal.theCommandLoop();
        assertEquals(testCommand.getClass(), terminal.getCurrentCommand().getClass());
    }

    @Test
    public void cmdHistoryTest (){
        cmdString1 = "history";
        terminal.setCommandString(cmdString1);
        Command testCommand = new CommandHistoryDoskeyh();
        terminal.theCommandLoop();
        assertEquals(testCommand.getClass(), terminal.getCurrentCommand().getClass());
    }

    @Test
    public void listIsEmptyTest (){
        homeFolder = new MockedFolder("HomeFolder", null);
        cmdString1 = "mkdir HomeFolder";
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString(cmdString1);
        terminal.theCommandLoop();
        terminal.clearHistory ();
        assertEquals(testCommandHistory, terminal.getCommandHistory());

    }

}
