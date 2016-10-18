package se.inte;

/**
 * Created by Melke on 17/10/16.
 */
public class CommandExit extends Command {

    public void execute(Terminal terminal){
        System.out.println("[Process completed]");
    }
}
