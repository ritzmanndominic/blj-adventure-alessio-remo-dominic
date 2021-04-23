package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Items> itemList = new ArrayList<>();
    private int lives;
    private int maxLives;

    public Player() {
    }

    public Player(ArrayList<Items> itemList, int lives) {
        this.itemList = itemList;
        this.lives = lives;
        this.maxLives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public ArrayList<Items> getItemList() {
        return itemList;
    }

    public int getMaxLives() {
        return maxLives;
    }
}