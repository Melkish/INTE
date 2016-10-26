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
    private String cmdString2;

    private MockedFolder homeFolder;
    private Terminal terminal;
    private Command testCommand;

    @Before
    public void before (){
        terminal = new Terminal ();
        testCommandHistory = new ArrayList<>();
    }

    @Test
    public void getCommandHistoryTest (){
        homeFolder = new MockedFolder("HomeFolder", null);
        cmdString1 = "mkdir HomeFolder";
        cmdString2 = "doskey /h";
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString(cmdString1);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        terminal.setCommandString(cmdString2);
        testCommandHistory.add(cmdString1);
        testCommandHistory.add(cmdString2);
        command = new Command();
        subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertEquals(testCommandHistory, terminal.getCommandHistory());

    }
    @Test
    public void cmdDoskeyhTest (){
        cmdString1 = "doskey /h";
        terminal.setCommandString(cmdString1);
        testCommand = new CommandHistoryDosKeyH();
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertEquals(testCommand.getClass(), terminal.getCurrentCommand().getClass());
    }

    @Test
    public void cmdHistoryTest (){
        cmdString1 = "history";
        terminal.setCommandString(cmdString1);
        testCommand = new CommandHistoryDosKeyH();
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertEquals(testCommand.getClass(), terminal.getCurrentCommand().getClass());
    }


/*
    @Test
    public void listIsEmptyTest (){
        homeFolder = new MockedFolder("HomeFolder", null);
        cmdString2 = "mkdir HomeFolder";
        terminal.setCurrentFolder(homeFolder);
        terminal.setCommandString(cmdString2);
        Command command = new Command();
        Command subCommand = command.executeCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        terminal.clearHistory ();
        assertEquals(testCommandHistory, terminal.getCommandHistory());

    }
*/
}
