package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String name;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();
    private ArrayList<Room> connector = new ArrayList<>();
    private ArrayList<String> commands = new ArrayList<>(Arrays.asList("north", "east", "south", "west"));

    public Room(){}

    public Room(String name, ArrayList<Items> itemsArrayList) {
        this.itemsArrayList = itemsArrayList;
        this.connector = new ArrayList<Room>();


        //connector.add(new Room("Office", 2, Direction.NOEXIT, Direction.NOEXIT, 1 ));
    }

}
