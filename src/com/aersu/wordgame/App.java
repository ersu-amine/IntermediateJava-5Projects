package com.aersu.wordgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String [] words = {"coffee","tea","milk","juice","soup","water"};

        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("Let's play a game.");
        do{
            WordGuessingGame game = new WordGuessingGame(words,9);
            //play game and get guessed word if won the game
            String word = game.play();
            //TODO implement removal of guessed word
            System.out.println(word);
            words = WordGuessingGame.removeGuessedWord(words,word);
            System.out.println("Arrays.toString(words) = " + Arrays.toString(words));

            //ask for second game
            System.out.print("Would you like to play another game? yes or no: ");
            answer = input.nextLine();

        }while(answer.toLowerCase().equals("yes"));

    }


}
