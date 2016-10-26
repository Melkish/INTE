package se.inte;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melke on 17/10/16.
 */
public class CommandExitTest {

    @Test
    public void commandExitTest(){
        Terminal terminal = new Terminal();
        terminal.setCommandString("exit");
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        assertTrue(terminal.getCurrentCommand() instanceof CommandExit);
    }

}