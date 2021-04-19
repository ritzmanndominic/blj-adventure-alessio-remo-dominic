package com.company;

import java.util.ArrayList;

public class Door {
    private Room[] connector;
    private boolean locked;

    public Door() {
    }

    public Door(Room[] connector, boolean locked) {
        this.connector = connector;
        this.locked = locked;
    }

    public Room[] getConnector() {
        return connector;
    }

    public void setConnector(Room[] connector) {
        this.connector = connector;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
