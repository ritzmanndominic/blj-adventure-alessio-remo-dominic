package sample;

import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();
    private boolean enemy;
    
    public Room() {
    }

    public Room(String name, boolean enemy) {
        this.name = name;
        this.enemy = enemy;
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

    public void setItemsArrayList(ArrayList<Items> itemsArrayList) { this.itemsArrayList = itemsArrayList; }

    public boolean isEnemy() { return enemy; }

    public void setEnemy(boolean enemy) { this.enemy = enemy; }
}