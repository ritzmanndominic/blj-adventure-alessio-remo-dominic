package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String name;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();


    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Items> getItemsArrayList() {
        return itemsArrayList;
    }
}