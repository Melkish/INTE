package se.inte;

/**
 * Created by Melke on 19/10/16.
 */
public class MockedFile implements File {

    private String fileName;
    private Folder parentFolder;
    private boolean hidden;
    private int size;

    public MockedFile(String fileName, Folder parentFolder, boolean hidden, int size) {
        this.fileName = fileName;
        this.parentFolder = parentFolder;
        this.hidden = hidden;
        this.size = size;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public Folder getParentFolder() {
        return this.parentFolder;
    }

    @Override
    public void setFileName(String newName) {
        this.fileName = newName;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public int getSize() {
        return size;
    }
}
