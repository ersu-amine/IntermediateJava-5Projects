package com.aersu.wordgame;

import java.util.Random;

public class WordGuessingGame {
    public WordGuessingGame(String[] words, int possibleAttempts){
        //selecting random word from words array to be guessed
        Random random = new Random();
        this.wordToGuess = words[random.nextInt(words.length)];
        guessedLetters = new char[this.wordToGuess.length()];
    }

    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    /**
     *
     * @param array filled with underscore characters
     */
    public static void fillArray(char[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = '_';
        }
    }
}
