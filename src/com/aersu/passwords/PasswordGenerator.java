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

        for (int i = 0; i < length; i++) {
            password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));

        }

        //return String.valueOf(password);
        return password.toString();
    }


}
