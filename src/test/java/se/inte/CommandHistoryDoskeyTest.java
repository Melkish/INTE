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
        homeFolder = new MockedFolder("HomeFolder", null);
        cmdString1 = "mkdir HomeFolder";
        terminal.setCurrentFolder(homeFolder);
    }

    @Test
    public void getCommandHistory (){
        terminal.setCommandString(cmdString1);
        testCommandHistory.add(cmdString1);
        terminal.theCommandLoop();
        assertEquals(testCommandHistory, terminal.getCommandHistory());

    }

}
