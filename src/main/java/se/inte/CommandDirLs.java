package se.inte;

public class CommandDirLs {

    private MyFile file;

    public CommandDirLs(MyFile file){
        this.file = file;
    }

    public MyFile getFile(){
        return this.file;
    }
}
