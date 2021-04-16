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
    private final Door door13 = new Door();

    public void createDoors(ArrayList<Door> doors) {

    }


    public void createRooms(ArrayList<Room> rooms){
        String[] RoomNames = {"Office", "Kitchen", "Bedroom", "Toilet", "Bathroom", "Balcony", "Storeroom", "Gym", "LivingRoom", "Secretroom"};
        for (String roomName : RoomNames) {
            Room room = new Room(roomName);
            rooms.add(room);
        }
    }

    public void createItems(ArrayList<Items> items){
        String[] itemNames = {"diamond", "gold", "coin", "golden skull", "ring", "sword", "bone", "cursed book", "wine", "easter egg"};
        boolean[] alarm = {false, false, false, true, false, true, true, true, false, false};
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

    public void addRoom(ArrayList<Room> rooms){
        door1.setConnector(new Room[]{rooms.get(0), rooms.get(1)});
        door2.setConnector(new Room[]{rooms.get(1), rooms.get(2)});
        door3.setConnector(new Room[]{rooms.get(1), rooms.get(7)});
        door4.setConnector(new Room[]{rooms.get(7), rooms.get(5)});
        door5.setConnector(new Room[]{rooms.get(7), rooms.get(8)});
        door6.setConnector(new Room[]{rooms.get(8), rooms.get(2)});
        door7.setConnector(new Room[]{rooms.get(8), rooms.get(5)});
        door8.setConnector(new Room[]{rooms.get(8), rooms.get(4)});
        door9.setConnector(new Room[]{rooms.get(4), rooms.get(6)});
        door10.setConnector(new Room[]{rooms.get(6), rooms.get(2)});
        door11.setConnector(new Room[]{rooms.get(2), rooms.get(3)});
        door12.setConnector(new Room[]{rooms.get(6), rooms.get(0)});
        door13.setConnector(new Room[]{rooms.get(0), rooms.get(9)});
    }
}
