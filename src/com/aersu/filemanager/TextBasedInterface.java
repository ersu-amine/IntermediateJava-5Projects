package com.aersu.filemanager;

import java.util.Scanner;

public class TextBasedInterface implements UserInterface {
    private UIEventHandler handler = null;

    @Override
    public void start() {
        System.out.println("________File Manager Menu________");
        System.out.println("1. List Files\n2. Create a Directory\n3. Delete a File or Directory\n4. Exit the Program");
        System.out.println("Please enter your choice as digit: ");
        Scanner input = new Scanner(System.in);

        while(true){
            int choice = input.nextInt();
            //clear the line to accommodate for pressing ENTER key
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Please enter directory path ");
                    handler.onList(input.nextLine());
                    break;
                case 2:
                    System.out.println("Please enter path new directory ");
                    handler.onCreate(input.nextLine());
                    break;
                case 3:
                    System.out.println("Please enter path of file or directory ");
                    handler.onDelete(input.nextLine());
                    break;
                case 4:
                    System.out.println("Exiting the program. Bye bye.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    @Override
    public void subscribe(UIEventHandler handler) {
        if (this.handler == null) {
            this.handler = handler;
        }
    }

    @Override
    public void display(String message) {
        //TODO implement way to utilize the method, refactor FileManager with String returning methods to be used in this method
        System.out.println(message);
    }
}
