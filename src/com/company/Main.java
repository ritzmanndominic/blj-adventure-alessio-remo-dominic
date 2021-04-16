package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Items> items = new ArrayList<>();
        Game game = new Game();
        game.createRooms(rooms);
        game.createItems(items);
        game.addItems(rooms, items);
    }
}
