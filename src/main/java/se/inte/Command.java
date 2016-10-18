package se.inte;

public class Command {

    public Command executeCommand(Terminal terminal) {
        System.out.print("Command> ");
        String commandString = terminal.getCommandString();

        if (commandString.startsWith("cd")) {
            return new CommandCd();
        } else if (commandString.startsWith("dir") || commandString.startsWith("ls")) {
            return new CommandDirLs();
        } else if (commandString.startsWith("mkdir")){
            return new CommandMkDir();
        } else if(commandString.startsWith("chdir") || commandString.startsWith("pwd")){
            return new CommandPwdChdir();
        } else if (commandString.equalsIgnoreCase("exit")){
            return new CommandExit();
        } else
            return new CommandUnknown();
    }

    public void execute(Terminal terminal){
        System.out.println("poop");
    }
}
