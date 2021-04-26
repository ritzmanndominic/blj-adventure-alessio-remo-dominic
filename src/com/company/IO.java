package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class IO {

    Scanner scn = new Scanner(System.in);


    public void switcher(Game game, Player player, long startTime) throws Exception {

        int choice;
        do {
            map(game);
            choice = scn.nextInt();
            game.safeMove(game, player, startTime, 0);
            switch (choice) {
                //print possible rooms
                case 1 -> possibleRoom(game.getActiveRoom(), game);

                //move between rooms
                case 2 -> game.move(game);

                //check if room has item
                case 3 -> game.inspectRoom(player);

                //show inventory
                case 4 -> printInventory(player, game);

                //save Data
                case 5 -> StoreScore.saveObject("Store_Location-Items", player, game);

                //Load Data
                case 6 -> StoreScore.loadData("Store_Location-Items", player, game);

                //play time
                case 7 -> game.gameTime(game, player, startTime);

                //go romm back
                case 8 -> game.safeMove(game, player, startTime, 1);

                //Exit program
                case 9 -> System.exit(0);
            }
        } while (choice != 7);


    }


    public static void drawMultipleBox(int maxLength, int width, int height, Game game, String... strings) {
        final String HO_LINE = "\u2550";
        final String VER_LINE = "\u2551";
        final String CORNER_1 = "\u2554";
        final String CORNER_2 = "\u2557";
        final String CORNER_3 = "\u255D";
        final String CORNER_4 = "\u255A";
        final String SPACE = " ";
        int[] lengthDifference;

        for (String s : strings) {
            maxLength = Math.max(s.length(), maxLength);
        }
        int leftDistance = 1; //Index of lengthDifference Array
        int rightDistance = 2; //Index of lengthDifference Array
        for (int k = 0; k < height; k++) {
            for (int j = 0; j < width; j++) {
                if (k * width + j >= strings.length || strings[k * width + j].length() == 0) {
                    System.out.print(SPACE.repeat(2 + maxLength + 2));
                } else {
                    System.out.print(CORNER_1 + HO_LINE.repeat(maxLength) + CORNER_2 + SPACE.repeat(2));
                }
            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                String printText;
                if (k * width + j < strings.length) printText = strings[k * width + j];
                else printText = "";
                lengthDifference = getLength(maxLength, printText.length());
                printText = printText.replace(game.getRooms().get(game.getActiveRoom()).getName(),
                        "\u001B[35m" + printText + "\u001B[0m");
                if (k * width + j >= strings.length || strings[k * width + j].length() == 0) {
                    System.out.print(SPACE.repeat(2 + maxLength + 2));
                } else {
                    System.out.print(VER_LINE + SPACE.repeat(lengthDifference[leftDistance]) + printText +
                            SPACE.repeat(lengthDifference[rightDistance]) + VER_LINE + SPACE.repeat(2));
                }
            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                if (k * width + j >= strings.length || strings[k * width + j].length() == 0) {
                    System.out.print(SPACE.repeat(2 + maxLength + 2));
                } else {
                    System.out.print(CORNER_4 + HO_LINE.repeat(maxLength) + CORNER_3 + SPACE.repeat(2));
                }
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
        System.out.print("\u001B[0m");
        drawMultipleBox(20, 4, 4, game, "", "Balcony", "Balcony", "Balcony",
                "Bathroom", "Living room", "Living room", "Gym", "Storeroom", "Bedroom", "Bedroom", "Kitchen",
                "", "Toilet", "Secret room", "Office");
        System.out.println("\u001B[36m");
        drawMultipleBox(24, 3, 3, game, " 1: Print out the possible rooms ",
                " 2: Move between rooms", "3: to inspect the room", "4: show inventory",
                "5: Save data", "6: Load old data","7: output playtime","8: go one Room back", "9: exit game");
        System.out.print("\u001B[0m");
    }

    public void possibleRoom(int activeRoom, Game game) {
        System.out.print("Possible rooms: ");
        boolean first = false;
        for (int i = 0; i < game.getDoors().size(); i++) {
            if (game.getDoors().get(i).getConnector()[0] == game.getRooms().get(activeRoom)) {
                if (first) {
                    System.out.print(", ");
                }
                System.out.print(game.getDoors().get(i).getConnector()[1].getName());
                first = true;
            } else if (game.getDoors().get(i).getConnector()[1] == game.getRooms().get(activeRoom)) {
                if (first) {
                    System.out.print(", ");
                }
                System.out.print(game.getDoors().get(i).getConnector()[0].getName());
                first = true;
            }
        }
        System.out.println("\n");
    }


    public void printHeart(int amount, String color) {
        if (color.equals("red")) {
            System.out.println("\u001B[31m");
        } else if (color.equals("green")) {
            System.out.println("\u001B[32m");
        }
        for (int i = 0; i < amount; i++) {
            System.out.print("  ░░░░   ░░░░  ");
        }
        System.out.println();
        for (int i = 0; i < amount; i++) {
            System.out.print(" ░░░░░░ ░░░░░░ ");
        }
        System.out.println();
        for (int i = 0; i < amount; i++) {
            System.out.print("  ░░░░░░░░░░░  ");
        }
        System.out.println();
        for (int i = 0; i < amount; i++) {
            System.out.print("    ░░░░░░░    ");
        }
        System.out.println();
        for (int i = 0; i < amount; i++) {
            System.out.print("      ░░░      ");
        }
        System.out.println("\n\u001B[0m");
    }

    public void printInventory(Player player, Game game) {
        int amountBoxesInRow = 3;
        String[] name = new String[player.getItemList().size()];
        for (int i = 0; i < player.getItemList().size(); i++) {
            name[i] = player.getItemList().get(i).getName();
        }

        if (player.getItemList().size() == 0) {
            System.out.println("Your inventory is empty, collect items with the inspect room command");
        } else {
            System.out.println("[Inventory]");
            drawMultipleBox(20, amountBoxesInRow, (player.getItemList().size() / amountBoxesInRow + 1),
                    game, name);
        }
        System.out.println("\n");
    }
}