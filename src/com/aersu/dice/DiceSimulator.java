package com.aersu.dice;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DiceSimulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello " + name);
        boolean validInput = false;
        int diceCount = 0;
        do {
            try {
                System.out.println("How many dice you want to roll");
                diceCount = input.nextInt(); //exception will be thrown in this line, if invalid
                validInput = true; //set to true to indicate successful completion possible
            } catch (InputMismatchException e) {
                System.out.println("Your input is invalid. Only positive integers can be entered ");
                input.next();
            } finally {
                //display rolled dice
                int counter = 0;
                while (counter != diceCount) {
                    rollDice();
                    counter++;
                }
            }
        } while (!validInput);
    }

    public static void rollDice() {
        Random random = new Random();
        //use with 2 arguments to create numbers from 1-6 inclusive
        //bound number is not inclusive
        //number to appear on dice
        int i = random.nextInt(1, 7);
        displayDice(i);
    }

    public static void displayDice(int number) {
        switch (number) {
            case 1:
                System.out.println("-------------\n|           |\n|     *     |\n|           |\n-------------");
                break;
            case 2:
                System.out.println("-------------\n|           |\n|   *   *   |\n|           |\n-------------");
                break;
            case 3:
                System.out.println("-------------\n| *         |\n|     *     |\n|         * |\n-------------");
                break;
            case 4:
                System.out.println("-------------\n|   *   *   |\n|           |\n|   *   *   |\n-------------");
                break;
            case 5:
                System.out.println("-------------\n|   *   *   |\n|     *     |\n|   *   *   |\n-------------");
                break;
            case 6:
                System.out.println("-------------\n|   *   *   |\n|   *   *   |\n|   *   *   |\n-------------");
                break;
            default:
                System.out.println("Not valid die value");
        }
    }
}


