package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Items> items = new ArrayList<>();
        ArrayList<Door> doors = new ArrayList<>();
        Game game = new Game();
        game.createRooms(rooms);
        game.createDoors(doors, rooms);
        game.addRoom(rooms, doors);
        game.createItems(items);
        game.addItems(rooms, items);
    }
}
