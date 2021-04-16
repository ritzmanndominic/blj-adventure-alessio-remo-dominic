package com.company;

import java.awt.image.ImageProducer;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.addItems();

        IO io = new IO();
        io.map();
        io.printBorder("Office");
    }
}
