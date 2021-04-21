package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        IO io = new IO();

        Game game = new Game();
        Player player = new Player();
        Player player1 = new Player(player.getItemList(), 3);
        game.manage(game.getItems(), game.getDoors(), game.getRooms());
        StoreScore.saveObject("Store_Location-Items", player1, game);

        io.switcher(game, player1);
        // StoreScore.readObject("Store_Location-Items");
    }
}