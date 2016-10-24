package se.inte;

/**
 * Created by Melke on 21/10/16.
 */
public class RealFile implements File {

    private String fileName;
    private Folder parentFolder;
    private boolean hidden;
    private int size;

    public RealFile(String fileName, Folder parentFolder, boolean hidden, int size) {
        this.fileName = fileName;
        this.parentFolder = parentFolder;
        this.hidden = hidden;
        this.size = size;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public Folder getParentFolder() {
        return parentFolder;
    }

    @Override
    public void setFileName(String newName) {

    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
