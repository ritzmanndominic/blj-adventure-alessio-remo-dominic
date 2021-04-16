package com.company;

import java.util.ArrayList;

public class Door {
    private ArrayList<Room> connector = new ArrayList<>();
    private boolean locked;

    public Door(){}

    public Door(ArrayList<Room> conector, boolean locked) {
        this.connector = conector;
        this.locked = locked;
    }
}
