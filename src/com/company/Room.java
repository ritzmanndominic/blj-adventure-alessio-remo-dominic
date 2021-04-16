package com.company;

import java.util.ArrayList;

public class Room {
    private int width;
    private int height;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();

    public Room(){}

    public Room(int width, int height, ArrayList<Items> itemsArrayList) {
        this.width = width;
        this.height = height;
        this.itemsArrayList = itemsArrayList;
    }
}
