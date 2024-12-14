package com.aersu.passwords;

public interface UserInterface {

    public int getPasswordLength();
    public boolean useLowercase();
    public boolean useUppercase();
    public boolean useNumbers();
    public boolean useSpecialChar();
    public void displayPassword(String password);
}
