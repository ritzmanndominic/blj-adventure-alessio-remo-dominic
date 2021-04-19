package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String name;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();
    private ArrayList<String> commands = new ArrayList<>(Arrays.asList("north", "east", "south", "west"));

    public Room(){}

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

    public void setItemsArrayList(ArrayList<Items> itemsArrayList) {
        this.itemsArrayList = itemsArrayList;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
}