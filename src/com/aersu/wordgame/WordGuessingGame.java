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

        //initializing guessed letters array after the selection of word
        guessedLetters = new char[this.wordToGuess.length()];
        //filling arrray with dashes to indicate unguessed letters
        Arrays.fill(guessedLetters, '_');
    }

    public String play() {
        Scanner input = new Scanner(System.in);
        boolean gameWon = false;
        String result = "";

        while (attempts > 0) {
            displayGameState();
            System.out.println("You have " + attempts + " remaining attempts");
            System.out.println("Make a guess: ");
            char letter = input.nextLine().toLowerCase().charAt(0);
            if (processGuess(letter)) {
                if (new String(guessedLetters).equals(wordToGuess)) {
                    System.out.println("You have guessed all letters. You won.");
                    //record the guessed word so it can be removed from array to prevent double game with same word
                    return wordToGuess;
                }
            } else {
                System.out.println("Try again :) ");
            }
            attempts--;
        }

        System.out.println("The word was " + wordToGuess + ". You are out of guesses. \nYou lose.");
        return result;
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

    //display letter
    private void displayGameState() {
        System.out.println("Guessed letters are: " + new String(guessedLetters));
    }

    public static String[] removeGuessedWord(String[] array, String word) {
        System.out.println("Arrays.toString(words) = " + Arrays.toString(array));
        String[] modifiedArray = new String[array.length - 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(word)) {
                array[i] = modifiedArray[index];
                index++;
            }

        }
        return modifiedArray;
    }
}
