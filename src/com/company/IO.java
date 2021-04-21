package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class IO {

    private int choice;
    Scanner scn = new Scanner(System.in);


    public void switcher(Game game, Player player) {

        do {
            System.out.println("\n1: Print out the Map\t 2: Print out the active Room you're in\t\t 3: Print out the possible rooms  \t 4: Move between rooms (X for exit)\t 6: Exit Program ");
            choice = scn.nextInt();

            switch (choice) {
                //print out map
                case 1 -> map(game);

                //print active room
                case 2 -> System.out.println((game.getRooms().get(game.getActiveRoom()).getName()));

                //print possible rooms
                case 3 -> possibleRoom(game.getActiveRoom(), game);

                //move between rooms
                case 4 -> game.move(game);

                //check if room has item
                case 5 -> game.inspectRoom(player);

                //Exit program
                case 6 -> System.exit(0);
            }
        } while (choice != 5);


    }


    public static void drawMultipleBox(int maxLength, int width, int height, Game game, String... strings) {
        final String HO_LINE = "\u2550";
        final String VER_LINE = "\u2551";
        final String CORNER_1 = "\u2554";
        final String CORNER_2 = "\u2557";
        final String CORNER_3 = "\u255D";
        final String CORNER_4 = "\u255A";
        final String SPACE = " ";
        final String BULLET = "\u2022";
        int[] lengthDifference;

        for (String s : strings) {
            maxLength = Math.max(s.length(), maxLength);
        }
        int leftDistance = 1; //Index of lengthDifference Array
        int rightDistance = 2; //Index of lengthDifference Array
        for (int k = 0; k < height; k++) {
            for (int j = 0; j < width; j++) {
                System.out.print(CORNER_1 + HO_LINE.repeat(maxLength) + CORNER_2 + SPACE.repeat(2));
            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                String printText;
                if (k * width + j < strings.length) printText = strings[k * width + j];
                else printText = "";
                printText = printText.replace(game.getRooms().get(game.getActiveRoom()).getName(), "\u001B[35m" + printText + "\u001B[0m");
                lengthDifference = getLength(maxLength, printText.length());

                System.out.print(VER_LINE + SPACE.repeat(lengthDifference[leftDistance]) + printText +
                        SPACE.repeat(lengthDifference[rightDistance]) + VER_LINE + SPACE.repeat(2));
            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(CORNER_4 + HO_LINE.repeat(maxLength) + CORNER_3 + SPACE.repeat(2));
            }
            System.out.println();
        }
    }

    private static int[] getLength(int maxLength, int usedLength) {
        int[] lengthDifference = new int[3];
        lengthDifference[0] = maxLength - usedLength;
        lengthDifference[1] = lengthDifference[0] / 2;
        if (lengthDifference[0] % 2 == 1) {
            lengthDifference[2] = lengthDifference[0] / 2 + 1;
        } else {
            lengthDifference[2] = lengthDifference[0] / 2;
        }
        return lengthDifference;
    }

    public void map(Game game) {
        System.out.println("[Map]");
        drawMultipleBox(20, 4, 4, game, "Balcony", "Balcony", "Balcony",
                "Bathroom", "Livingroom", "Livingroom", "Gym", "Storeroom", "Bedroom", "Bedroom", "Kitchen", "", "Toilet", "*Secretroom*", "Office");
    }

    public void printBorder(String word) {
        System.out.println("[" + word + "]");
        int positionDoor = word.length() + word.length() + 10;
        //print top of box
        System.out.print("\u2554");
        for (int i = 0; i < positionDoor; i++) {
            System.out.print("\u2550");
        }
        System.out.println("\u2557");
        //print middle of box
        System.out.print("\u2551");
        for (int x = 0; x < (word.length() + 10) / 2; x++) {
            System.out.print(" ");
        }
        System.out.print(word);
        for (int x = 0; x < (word.length() + 10) / 2; x++) {
            System.out.print(" ");
        }
        System.out.println("\u2551");
        //print bottom if box
        System.out.print("\u255A");
        for (int i = 0; i < positionDoor; i++) {
            if (positionDoor / 4 == i || positionDoor - (positionDoor / 4) == i) {
                System.out.print("\u2573");
            } else {
                System.out.print("\u2550");
            }
        }
        System.out.println("\u255D");
    }

    public void possibleRoom(int activeRoom, Game game) {
        System.out.print("Possible rooms: ");
        boolean first = false;
        for (int i = 0; i < game.getDoors().size(); i++) {
            if (game.getDoors().get(i).getConnector()[0] == game.getRooms().get(activeRoom)) {
                if(first){
                    System.out.print(", ");
                }
                System.out.print(game.getDoors().get(i).getConnector()[1].getName());
                first = true;
            } else if (game.getDoors().get(i).getConnector()[1] == game.getRooms().get(activeRoom)) {
                if(first){
                    System.out.print(", ");
                }
                System.out.print(game.getDoors().get(i).getConnector()[0].getName());
                first = true;
            }
        }
    }

    private static void colors() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
    }

}