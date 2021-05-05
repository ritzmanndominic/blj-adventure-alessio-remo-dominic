package com.company;

public class Main {

    public static void main(String[] args) {
        IO io = new IO();
        Game game = new Game();
        Player player1 = new Player(3);

        io.switcher(game, player1);
    }
}