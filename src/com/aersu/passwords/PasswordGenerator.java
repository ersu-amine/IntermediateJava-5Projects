package com.aersu.passwords;

import java.util.Random;

public class PasswordGenerator {

    String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useNum, boolean useSpecialChar) {
        //all lowercase letters
        final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
        final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String DIGITS = "1234567890";
        final String SPECIALCHARS = "!@#$%^&*()?";

        Random random = new Random();
        //to store generated password
        StringBuilder password = new StringBuilder();
        StringBuilder allChars = new StringBuilder();

        if(useLowercase){
            //add 1 letter from lowercase letter set
            password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
            allChars.append(LOWERCASE);
        }

        if(useUppercase){
            //add 1 letter from uppercase letter set
            password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
            allChars.append(UPPERCASE);
        }

        if(useSpecialChar){
            //add 1 letter from special character set
            password.append(SPECIALCHARS.charAt(random.nextInt(SPECIALCHARS.length())));
            allChars.append(DIGITS);
        }

        if(useNum){
            //add 1 letter from digit set
            password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
            allChars.append(DIGITS);
        }

        //check if password reached the desired length, iterate and add characters to password
        if (password.length()<length){
            for (int i = 0; i < length-password.length(); i++) {
                //add a character from pool of characters that user requested
                password.append(allChars.charAt(random.nextInt(allChars.length())));
            }
        }

        //return String.valueOf(password);
        return password.toString();
    }


}
