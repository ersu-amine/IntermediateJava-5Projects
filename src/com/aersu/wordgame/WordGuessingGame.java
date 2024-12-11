package com.aersu.wordgame;

import java.util.*;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] words, int possibleAttempts) {
        this.attempts = possibleAttempts;

        //selecting random word from words array to be guessed
        Random random = new Random();
        this.wordToGuess = words[random.nextInt(words.length)];
        System.out.println(wordToGuess);

        //initializing guessed letters array after the selection of word
        guessedLetters = new char[this.wordToGuess.length()];
        //filling arrray with dashes to indicate unguessed letters
        Arrays.fill(guessedLetters, '_');
    }

    public void play() {
        Scanner input = new Scanner(System.in);

        while (attempts > 0) {
            System.out.println("You have " + attempts + " remaining attempts");
            System.out.println("Make a guess: ");
            char letter = input.nextLine().toLowerCase().charAt(0);
            if (processGuess(letter)) {
                System.out.println("You have a guess!");
                System.out.println(Arrays.toString(guessedLetters));
            } else {
                System.out.println("Try again :) ");
            }
            attempts--;
        }

    }

    private boolean checkLetter(char letter) {

        //list of string because list accepts non-primitive types
        List<String> characters = new ArrayList<>(Arrays.asList(wordToGuess.split("")));

        //contains method returns true or false
        return characters.contains(String.valueOf(letter));
    }

    private boolean processGuess(char letter) {
        boolean correctGuess = false;
        if (checkLetter(letter)) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                }
            }
            correctGuess = true;
        }
        return correctGuess;
    }
}
