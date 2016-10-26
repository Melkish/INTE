package se.inte;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class CommandDirLsTest {

    private Folder homeFolder;
    private Folder subFolder1;
    private Folder subFolder2;
    private Folder subFolder3;
    private Terminal terminal;
    private File testFile1;
    private File testFile2;
    private File testFile3;

    @Before
    public void before(){
        homeFolder = new MockedFolder("topfolder", null);
        subFolder1 = homeFolder.createSubFolder("subfolder1");
        subFolder2 = homeFolder.createSubFolder("subfolder2");
        subFolder3 = homeFolder.createSubFolder("subfolder3");
        testFile1 = homeFolder.createFile("testFile1", true, 10);
        testFile2 = homeFolder.createFile("testFile2", false, 5);
        testFile3 = homeFolder.createFile("testFile3", true, 20);
        terminal = new Terminal();
    }

    @Test
    public void commandDirPrintsSubFoldersTest(){
        terminal.setCommandString("dir");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        ArrayList<File> files = ((CommandDirLs) command).getPrintedFileList();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2)
                && subFolders.contains(subFolder3) && files.contains((testFile2)));
    }

    @Test
    public void commandLsPrintsSubFoldersTest(){
        terminal.setCommandString("ls");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        ArrayList<File> files = ((CommandDirLs) command).getPrintedFileList();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        assertTrue(subFolders.contains(subFolder1) && subFolders.contains(subFolder2)
                && subFolders.contains(subFolder3) && files.contains(testFile2));
    }

    @Test
    public void printAllTest(){
        terminal.setCommandString("ls -a");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        ArrayList<Folder> subFolders = ((CommandDirLs) command).getPrintedSubFolderList();
        ArrayList<File> files = ((CommandDirLs) command).getPrintedFileList();
        assertTrue(files.contains(testFile1) && files.contains(testFile2) && files.contains(testFile3)
                && subFolders.contains(subFolder1) && subFolders.contains(subFolder2) && subFolders.contains(subFolder3));
    }

    @Test
    public  void printLongTest(){
        terminal.setCommandString("ls -l");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        ArrayList<File> files = ((CommandDirLs) command).getPrintedFileList();
        assertEquals(5, files.get(0).getSize());

    }

    @Test
    public void hiddenFilesAreNotPrintedTest(){
        terminal.setCommandString("ls");
        terminal.setCurrentFolder(homeFolder);
        Command command = new Command();
        Command subCommand = command.checkCommand(terminal);
        subCommand.execute(terminal);
        terminal.setCommand(subCommand);
        command = terminal.getCurrentCommand();
        ArrayList<File> files = ((CommandDirLs) command).getPrintedFileList();
        assertFalse(files.contains(testFile1) && files.contains(testFile3));
    }


}
