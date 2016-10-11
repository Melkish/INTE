package se.inte;

import java.io.File;

public class CommandDirLs {

    private File file;

    public CommandDirLs(File file){
        this.file = file;
    }

    public File getFile(){
        return this.file;
    }
}
