package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Items> itemList = new ArrayList<>();
    private int lives;
    private ArrayList<String> location = new ArrayList<>();
    private boolean secretKey;

    public Player(){}

    public Player(ArrayList<Items> itemList, int lifes, ArrayList<String> location, boolean secretKey) {
        this.itemList = itemList;
        this.lives = lifes;
        this.location = location;
        this.secretKey = secretKey;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}