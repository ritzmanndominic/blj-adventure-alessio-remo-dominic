package com.company;

import java.util.ArrayList;

public class Game {

    public void createDoors(ArrayList<Door> doors, ArrayList<Room> rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            doors.add(new Door());
        }
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

    public void addRoom(ArrayList<Room> rooms, ArrayList<Door> doors){
        doors.get(0).setConnector(new Room[]{rooms.get(0), rooms.get(1)});
        doors.get(1).setConnector(new Room[]{rooms.get(1), rooms.get(2)});
        doors.get(2).setConnector(new Room[]{rooms.get(1), rooms.get(7)});
        doors.get(3).setConnector(new Room[]{rooms.get(7), rooms.get(5)});
        doors.get(4).setConnector(new Room[]{rooms.get(7), rooms.get(8)});
        doors.get(5).setConnector(new Room[]{rooms.get(8), rooms.get(2)});
        doors.get(6).setConnector(new Room[]{rooms.get(8), rooms.get(5)});
        doors.get(7).setConnector(new Room[]{rooms.get(8), rooms.get(4)});
        doors.get(8).setConnector(new Room[]{rooms.get(4), rooms.get(6)});
        doors.get(9).setConnector(new Room[]{rooms.get(6), rooms.get(2)});
        doors.get(10).setConnector(new Room[]{rooms.get(2), rooms.get(3)});
        doors.get(11).setConnector(new Room[]{rooms.get(6), rooms.get(0)});
        doors.get(12).setConnector(new Room[]{rooms.get(0), rooms.get(9)});
    }
}
