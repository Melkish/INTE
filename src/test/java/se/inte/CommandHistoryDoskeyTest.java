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
    private Terminal terminal;
    private Command command;

    @Before
    public void before (){
        terminal = new Terminal ();
        testCommandHistory = new ArrayList<>();
        testCommandHistory.add("mkdir");
        testCommandHistory.add("mkdir");
        testCommandHistory.add("doskey");

        terminal.setCommandString("mkdir");
        terminal.saveCommandToHistory("mkdir");
        terminal.saveCommandToHistory("mkdir");
    }

    @Test
    public void getDoskeyCommandHistoryTest (){
        terminal.setCommandString("doskey");
        terminal.theCommandLoop();
        assertEquals(testCommandHistory, terminal.getCommandHistory ());

    }

    @Test
    public void getHistoryCommandHistoryTest (){
        terminal.setCommandString("history");
        terminal.theCommandLoop();
        assertEquals(testCommandHistory, terminal.getCommandHistory ());

    }

}
