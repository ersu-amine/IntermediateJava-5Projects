package com.aersu.passwords;

public class App {
    public static void main(String [] args){
        //create instance of textbased interface
        UserInterface userInterface = new TextBasedUserInterface();
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(userInterface.getPasswordLength()
                , userInterface.useLowercase(),
                userInterface.useUppercase(),
                userInterface.useNumbers(),
                userInterface.useSpecialChar());
        userInterface.displayPassword(password);
        //TODO implement try catch to prevent user requesting shorter password length than possible
        //length 3, but said yes to all , cannot be less than 4 to have chars from each option set
    }
}
