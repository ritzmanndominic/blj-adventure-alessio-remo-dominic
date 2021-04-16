package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String name;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();
    private ArrayList<String> commands = new ArrayList<>(Arrays.asList("north", "east", "south", "west"));

    Items items = new Items();

    public Room(){}

    public Room(String name, ArrayList<Items> itemsArrayList) {
        this.name = name;
        this.itemsArrayList = itemsArrayList;
    }

    Room office = new Room("Office", itemsArrayList);

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

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Room getOffice() {
        return office;
    }

    public void setOffice(Room office) {
        this.office = office;
    }
}
