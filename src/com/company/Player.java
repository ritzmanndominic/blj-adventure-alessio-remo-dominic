package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Items> itemList = new ArrayList<>();
    private int lifes;
    private ArrayList<String> location = new ArrayList<>();

    public Player() {
    }

    public Player(ArrayList<Items> itemList, int lifes, ArrayList<String> location) {
        this.itemList = itemList;
        this.lifes = lifes;
        this.location = location;
    }
}
