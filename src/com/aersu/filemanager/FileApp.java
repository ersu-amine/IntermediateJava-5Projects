package com.aersu.filemanager;

public class FileApp implements UIEventHandler{
    FileManager manager;

    public FileApp(){
        this.manager = new FileManager();
    }

    public static void main(String[] args) {

        FileManager manager = new FileManager();
        UserInterface userInterface = new TextBasedInterface();
        userInterface.subscribe(new FileApp());
        userInterface.start();
    }

    @Override
    public void onList(String path) {
        this.manager.listFiles(path);
    }

    @Override
    public void onCreate(String path) {
        this.manager.createDirectory(path);
    }

    @Override
    public void onDelete(String path) {
        this.manager.deleteFileOrDirectory(path);
    }
}
