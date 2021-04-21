package com.company;

import java.util.Scanner;

public class IO {

    private int chooice;
    Scanner scn = new Scanner(System.in);


    public void switcher(Game game) {

        do {
            System.out.println("\n1: Print out the Map\t 2: Print out the active Room you're in\t\t 3: Print out the possible rooms \t 4: Exit Program ");
            chooice = scn.nextInt();

            switch (chooice) {
                //print out map
                case 1 -> map();

                //print active room
                case 2 -> System.out.println(game.getActiveRoom());

                //print possible rooms
                case 3 -> possibleRoom(5, game);

                case 4 -> System.exit(0);
            }
        } while (chooice != 4);


    }


    public static void drawMultipleBox(int maxLength, int width, int height, String... strings) {
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

    public void map() {
        System.out.println("[Map]");
        drawMultipleBox(20, 3, 4, "", "Balcony", "Balcony",
                "Bathroom", "Livingroom", "Gym", "Storeroom", "Bedroom", "Kitchen", "Toilet", "*Secretroom*", "Office");
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

    public void possibleRoom(int activeroom, Game game) {
        Room[] rooms = game.getDoors().get(activeroom).getConnector();
        System.out.println("Possible rooms: " + rooms[0].getName() + ", " + rooms[1].getName());
    }

}