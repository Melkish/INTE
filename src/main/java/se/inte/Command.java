package se.inte;

public class Command {
    public Command executeCommand(Terminal terminal) {
        System.out.println("Command> ");
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
        } else if (commandString.startsWith("cp -r") || commandString.startsWith("xcopy")){
            return new CommandCpXcopy();
        } else if (commandString.startsWith("rmdir")){
            return new CommandRmdir();
        } else if (commandString.startsWith("doskey /h") || commandString.startsWith("history")){
            return new CommandHistoryDoskeyh();
        } else if (commandString.startsWith("mv") || commandString.startsWith("ren")) {
            return new CommandMvRen();
        } else
            return new CommandUnknown();
    }

    public void execute(Terminal terminal){
        System.out.println("poop");
    }
}
