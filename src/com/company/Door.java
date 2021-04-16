package com.company;

import java.util.ArrayList;

public class Door {
    private ArrayList<Room> conector = new ArrayList<>();
    private boolean locked;

    public Door(){}

    public Door(ArrayList<Room> conector, boolean locked) {
        this.conector = conector;
        this.locked = locked;
    }
}
