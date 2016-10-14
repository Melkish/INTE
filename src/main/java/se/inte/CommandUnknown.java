package se.inte;

public class CommandUnknown extends Command {

    public void execute(Terminal terminal){
        System.out.println("Unknown command");
    }
}
