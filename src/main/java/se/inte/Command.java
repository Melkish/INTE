package se.inte;

import java.util.Scanner;

public class Command {


    public Command checkCommand(Terminal terminal) {
        String commandString = terminal.getCommandString();

        if (commandString.startsWith("cd")) {
            return new CommandCd();
        } else if (commandString.startsWith("dir") || commandString.startsWith("ls")) {
            return new CommandDirLs();
        } else if (commandString.startsWith("mkdir")){
            return new CommandMkDir();
        } else if(commandString.startsWith("chdir") || commandString.startsWith("pwd")){
            return new CommandPwdChDir();
        } else if (commandString.equalsIgnoreCase("exit")){
            return new CommandExit();
        } else if (commandString.startsWith("cp -r") || commandString.startsWith("xcopy")){
            return new CommandCpXcopy();
        } else if (commandString.startsWith("rmdir")){
            return new CommandRmDir();
        } else if (commandString.startsWith("doskey /h") || commandString.startsWith("history")){
            return new CommandHistoryDosKeyH();
        } else if (commandString.startsWith("mv") || commandString.startsWith("ren")) {
            return new CommandMvRen();
        } else
            return new CommandUnknown();
    }

    public static String getCommandString(String location){
        System.out.print(location);
        Scanner scanner = new Scanner(System.in);
        String commandString = scanner.nextLine();
        System.out.println("");
        return commandString;
    }

    public void execute(Terminal terminal){
        System.out.println("Need to override in subclass");
    }
}
