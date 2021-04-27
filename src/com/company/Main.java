package com.company;

import java.sql.Timestamp;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        IO io = new IO();
        Game game = new Game();
        Player player = new Player();
        Player player1 = new Player(player.getItemList(), 3);

        game.manage(game.getItems(), game.getDoors(), game.getRooms());
        io.switcher(game, player1, startTime, ts);
      //  game.fight("Fight", player1, game);
    }
}