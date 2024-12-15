package com.aersu.filemanager;

import java.io.File;

public class FileManager {
    public void listFiles(String directoryPath) {
        File directory = new File(directoryPath);
        //check directory
        if (directory.exists() && directory.isDirectory()) {
            File[] contents = directory.listFiles();

            //if it is not empty, check content
            if (contents != null) {
                for (File file : contents) {
                    if (file.isDirectory()) {
                        System.out.println("[DIR] " + file.getName());
                    } else {
                        System.out.println("[FILE] " + file.getName());
                    }
                }
            } else { //it is empty
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Invalid path: given path is not a directory or it is incorrect.");
        }
    }

    public void createDirectory(String directoryPath) {
        //can have file object even if the directory is not existing
        File directory = new File(directoryPath);
        //create directory
        if (directory.mkdir()) { //returns true if successful
            System.out.println("Directory has been created. SUCCESS.");
        } else {
            System.out.println("Directory has NOT been created. FAIL.");
        }
    }

    public void deleteFileOrDirectory(String directoryOrFilePath) {
        File file = new File(directoryOrFilePath);
        //delete the directory or file
        if (file.delete()) {//returns true if successful
            System.out.println("File/Directory has been deleted. SUCCESS.");

        } else {
            System.out.println("File/Directory has NOT been deleted. FAIL.");
        }
    }
}
