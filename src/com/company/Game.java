package com.company;

import java.util.ArrayList;

public class Game {
    private final Door door1 = new Door();
    private final Door door2 = new Door();
    private final Door door3 = new Door();
    private final Door door4 = new Door();
    private final Door door5 = new Door();
    private final Door door6 = new Door();
    private final Door door7 = new Door();
    private final Door door8 = new Door();
    private final Door door9 = new Door();
    private final Door door10 = new Door();
    private final Door door11 = new Door();
    private final Door door12 = new Door();

    public void createDoors(ArrayList<Doors> doors) {
        
    }


    public void createRooms(ArrayList<Room> rooms){
        String[] RoomNames = {"Office", "Kitchen", "Bedroom", "Toilet", "Bathroom", "Balcony", "Storeroom", "Gym", "LivingRoom", "Secretroom"};
        for (String roomName : RoomNames) {
            Room room = new Room(roomName);
            rooms.add(room);
        }
    }

    public void createItems(ArrayList<Items> items){
        String[] itemNames = {"diamond", "gold", "coin", "golden skull", "ring", "sword", "bone", "cursed book", "easter egg"};
        boolean[] alarm = {false, false, false, true, false, true, true, true, false};
        for (int i = 0; i < itemNames.length; i++) {
            Items item = new Items(itemNames[i], alarm[i]);
            items.add(item);
        }
    }

    public void addItems(ArrayList<Room> rooms, ArrayList<Items> items){
        for(int i = 0; i < rooms.size(); i++) {
            rooms.get(i).getItemsArrayList().add(items.get(i));
        }
    }

    public void addRoom(){
        door1.setConnector(new Room[]{office, kitchen});
        door2.setConnector(new Room[]{kitchen, bedroom});
        door3.setConnector(new Room[]{kitchen, gym});
        door4.setConnector(new Room[]{gym, balcony});
        door5.setConnector(new Room[]{gym, livingroom});
        door6.setConnector(new Room[]{livingroom, bedroom});
        door7.setConnector(new Room[]{livingroom, balcony});
        door8.setConnector(new Room[]{livingroom, bathroom});
        door9.setConnector(new Room[]{bathroom, storeroom});
        door10.setConnector(new Room[]{storeroom, bedroom});
        door11.setConnector(new Room[]{bedroom, toilett});
        door12.setConnector(new Room[]{secretroom, office});
    }
}
