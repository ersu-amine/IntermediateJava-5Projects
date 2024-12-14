package com.aersu.passwords;

import java.util.Scanner;

public class TextBasedUserInterface implements UserInterface{
    private Scanner scan;

    public TextBasedUserInterface(){
        this.scan = new Scanner(System.in);
    }

    @Override
    public int getPasswordLength() {
        System.out.println("Please enter your desired password length: ");
        return scan.nextInt();
    }

    @Override
    public boolean useLowercase() {
        System.out.println("Should your password contain lowercase characters? (yes/no) ");
        return scan.next().equalsIgnoreCase("yes");
    }

    @Override
    public boolean useUppercase() {
        System.out.println("Should your password contain uppercase characters? (yes/no) ");
        return scan.next().equalsIgnoreCase("yes");
    }

    @Override
    public boolean useNumbers() {
        System.out.println("Should your password contain numerical characters? (yes/no) ");
        return scan.next().equalsIgnoreCase("yes");
    }

    @Override
    public boolean useSpecialChar() {
        System.out.println("Should your password contain special characters? (yes/no) ");
        return scan.next().equalsIgnoreCase("yes");
    }

    @Override
    public void displayPassword(String password) {
        System.out.println("The password you have generated is: " + password);
    }
}
