package se.inte;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    Terminal terminal;
    Command command;
    String commandString = null;

    @Before
    public void before(){
        terminal = new Terminal();
        command = new Command();
    }

    @Test
    public void commandStringTest(){

    }

    @Test
    public void executeCommandTest(){
        terminal.setCommandString("cd");
        Command executedCommand = command.executeCommand(terminal);
        if (executedCommand instanceof CommandCd){
            commandString = ((CommandCd) executedCommand).getCommandName();
        }
        assertEquals("cd", commandString);
    }

}