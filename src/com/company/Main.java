package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        IO io = new IO();

        Game game = new Game();
        game.createRooms(game.getRooms());
        game.createDoors(game.getDoors());
        game.addRoom(game.getRooms(), game.getDoors());
        game.createItems(game.getItems());
        game.addItems(game.getRooms(), game.getItems());

        io.map();
        io.printBorder("Balcony ");
        game.move(game);
    }
}