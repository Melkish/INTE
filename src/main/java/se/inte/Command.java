package se.inte;

/**
 * Created by Melke on 12/10/16.
 */
public class Command {

    public Command executeCommand(Terminal terminal) {
        System.out.print("Command> ");
        String commandString = terminal.getCommandString();

        if (commandString.startsWith("cd")) {
            return new CommandCd();
        } else return null;
    }

    public void execute(Terminal terminal){
        System.out.print("poop");

    }

}
