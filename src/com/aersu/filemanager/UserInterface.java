package com.aersu.filemanager;

public interface UserInterface {
    public void start();
    public void subscribe(UIEventHandler handler);

    //display information to user
    public void display(String message);

}
