package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private final ArrayList<Room> rooms = new ArrayList<>();
    private final ArrayList<Items> items = new ArrayList<>();
    private final ArrayList<Door> doors = new ArrayList<>();
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
        String[] RoomNames = {"Office", "Kitchen", "Bedroom", "Toilet", "Bathroom", "Balcony", "Storeroom", "Gym", "Living room", "Secret room"};
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
            Random random = new Random();
            int randomNumber = random.nextInt(items.size());
            rooms.get(i).getItemsArrayList().add(items.get(randomNumber));
        }
    }
    
    public void move() {
        boolean validMove = false;
        String newRoom;
        String cancel = "x";
        do {
            System.out.print("\nType in the room you want to go in: ");
            newRoom = io.scn.nextLine();
            for (Door door : doors) {
                if (door.getConnector()[0].getName().toLowerCase().equals(newRoom.toLowerCase()) ||
                        door.getConnector()[1].getName().toLowerCase().equals(newRoom.toLowerCase())) {
                    if (door.getConnector()[0].getName().toLowerCase().equals(rooms.get(activeRoom).getName().toLowerCase()) ||
                            door.getConnector()[1].getName().toLowerCase().equals(rooms.get(activeRoom).getName().toLowerCase())) {
                        validMove = true;
                        for (int j = 0; j < rooms.size(); j++) {
                            if (newRoom.toLowerCase().equals(rooms.get(j).getName().toLowerCase())) {
                                activeRoom = j;
                            }
                        }
                    }
                }
            }
            if (newRoom.equals(cancel)) {
                validMove = true;
            } else {
                if (validMove) {
                    System.out.println("You entered the " + newRoom);
                } else {
                    System.out.print("The room could not be found, try again or press \"x\" to cancel");
                }
            }
        } while (!validMove);
    }

    public void inspectRoom(Player player) {
        if (!getItems().get(getActiveRoom()).getName().isEmpty()) {
            System.out.println("You have found " + getItems().get(getActiveRoom()).getName());
            if(getItems().get(getActiveRoom()).isAlarm()) {
                System.out.println("Oh no I shouldn't have taken that!");
                System.out.println("\u001B[31myou lost a life\u001B[0m");
                player.setLives(player.getLives() - 1);
                io.printHeart(player.getLives(), "red");
                player.getItemList().add(getItems().get(getActiveRoom()));
            }
            else if (player.getLives() < player.getMaxLives()) {
                player.setLives(player.getLives() + 1);
                System.out.println("\u001B[32mnice! I got an extra life\u001B[0m");
                io.printHeart(player.getLives(), "green");
            }
            else {
                io.printHeart(player.getLives(), "normal");
            }
            getItems().get(getActiveRoom()).setName("");
        }
        else {
            System.out.println("no item in this room");
        }
        if (player.getLives() == 0) {
            System.out.println("\u001B[31myou have died\u001B[0m");
            System.exit(0);
        }

    }

    public int getActiveRoom() {
        return activeRoom;
    }

    public void setActiveRoom(int activeRoom) {
        this.activeRoom = activeRoom;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

}