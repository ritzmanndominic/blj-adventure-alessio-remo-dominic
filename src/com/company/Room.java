package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String name;
    private int width;
    private int height;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();
    private ArrayList<Room> connector = new ArrayList<>();
    private ArrayList<String> commands = new ArrayList<>(Arrays.asList("north", "east", "south", "west"));

    public Room(){}

    public Room(String name, int width, int height, ArrayList<Items> itemsArrayList) {
        this.width = width;
        this.height = height;
        this.itemsArrayList = itemsArrayList;
        this.connector = new ArrayList<Room>();


        //connector.add(new Room("Office", 20, 20, Direction.NORTH, Direction.NOEXIT, Direction.NOEXIT, Direction.WEST ))
    }



}
