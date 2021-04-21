package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Items> items = new ArrayList<>();
    private ArrayList<Door> doors = new ArrayList<>();
    private int activeRoom = 5;

    IO io = new IO();

    public void manage(ArrayList<Items> items, ArrayList<Door> doors, ArrayList<Room> rooms){
        createRooms(rooms);
        createDoors(rooms, doors);
        createItems(items);
        addItems(rooms, items);
    }

    public void createDoors(ArrayList<Room> rooms, ArrayList<Door> doors) {
        doors.add(new Door(new Room[]{rooms.get(0), rooms.get(1)}, false));
        doors.add(new Door(new Room[]{rooms.get(0), rooms.get(9)}, true));
        doors.add(new Door(new Room[]{rooms.get(1), rooms.get(2)}, false));
        doors.add(new Door(new Room[]{rooms.get(1), rooms.get(7)}, false));
        doors.add(new Door(new Room[]{rooms.get(7), rooms.get(8)}, false));
        doors.add(new Door(new Room[]{rooms.get(7), rooms.get(5)}, false));
        doors.add(new Door(new Room[]{rooms.get(5), rooms.get(8)}, false));
        doors.add(new Door(new Room[]{rooms.get(8), rooms.get(4)}, false));
        doors.add(new Door(new Room[]{rooms.get(8), rooms.get(2)}, false));
        doors.add(new Door(new Room[]{rooms.get(2), rooms.get(3)}, false));
        doors.add(new Door(new Room[]{rooms.get(2), rooms.get(6)}, false));
        doors.add(new Door(new Room[]{rooms.get(6), rooms.get(4)}, false));
    }

    public void createRooms(ArrayList<Room> rooms) {
        String[] RoomNames = {"Office", "Kitchen", "Bedroom", "Toilet", "Bathroom", "Balcony", "Storeroom", "Gym", "Livingroom", "Secretroom"};
        for (String roomName : RoomNames) {
            Room room = new Room(roomName);
            rooms.add(room);
        }
    }

    public void createItems(ArrayList<Items> items) {
        String[] itemNames = {"diamond", "gold", "coin", "golden skull", "ring", "sword", "bone", "cursed book", "wine", "easter egg"};
        boolean[] alarm = {false, false, false, true, false, true, true, true, false, false};
        for (int i = 0; i < itemNames.length; i++) {
            Items item = new Items(itemNames[i], alarm[i]);
            items.add(item);
        }
    }

    public void addItems(ArrayList<Room> rooms, ArrayList<Items> items) {
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).getItemsArrayList().add(items.get(i));
        }
    }


    public void move(Game game) {
        boolean validMove = false;
        String newRoom;
        do {
            System.out.print("\nType in the room you want to go in: ");
            newRoom = io.scn.nextLine();
            for (int i = 0; i < doors.size(); i++) {
                if (doors.get(i).getConnector()[0].getName().toLowerCase().equals(newRoom.toLowerCase()) ||
                        doors.get(i).getConnector()[1].getName().toLowerCase().equals(newRoom.toLowerCase())) {
                    if (doors.get(i).getConnector()[0].getName().toLowerCase().equals(rooms.get(activeRoom).getName().toLowerCase()) ||
                            doors.get(i).getConnector()[1].getName().toLowerCase().equals(rooms.get(activeRoom).getName().toLowerCase())) {
                        validMove = true;
                        for (int j = 0; j < rooms.size(); j++) {
                            if (newRoom.toLowerCase().equals(rooms.get(j).getName().toLowerCase())) {
                                activeRoom = j;
                            }
                        }
                    }
                }
            }
            if (validMove) {
                System.out.println("You entered the " + newRoom);
            } else {
                System.out.print("The room could not be found, try again");
            }
        } while (!validMove);
    }

    public void inspectRoom(Player player) {
        System.out.println("You have found " + rooms.get(getActiveRoom()).getItemsArrayList().get(getActiveRoom()).getName());
        int lives = player.getLives();
        if (rooms.get(getActiveRoom()).getItemsArrayList().get(getActiveRoom()).isAlarm()) {
            player.setLives(lives - 1);
        }
    }

    public int getActiveRoom() {
        return activeRoom;
    }

    public void setActiveRoom(int activeRoom) {
        this.activeRoom = activeRoom;
    }

    public IO getIo() {
        return io;
    }

    public void setIo(IO io) {
        this.io = io;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }
}