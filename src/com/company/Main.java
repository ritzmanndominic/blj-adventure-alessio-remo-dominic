package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        IO io = new IO();

        Game game = new Game();
        Player player = new Player();
        game.createRooms(game.getRooms());
        game.createDoors(game.getRooms(), game.getDoors());
        game.createItems(game.getItems());
        game.addItems(game.getRooms(), game.getItems());
        StoreScore.saveObject("bananen", game);
        /*
        io.map();
        io.printBorder("Balcony ");
        game.move(game);
        */
        io.switcher(game, player);
       // StoreScore.readObject("bananen");
    }
}