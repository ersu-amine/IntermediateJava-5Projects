package com.aersu.wordgame;

public class App {
    public static void main(String[] args) {
        String [] words = {"coffee","tea","milk","juice","soup","water"};
        WordGuessingGame game = new WordGuessingGame(words,9);
        game.play();
    }
}
