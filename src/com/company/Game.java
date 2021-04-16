package com.company;

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

    private final Room office = new Room("Office");
    private final Room kitchen = new Room("Kitchen");
    private final Room bedroom = new Room("Bedroom");
    private final Room toilett = new Room("Toilett");
    private final Room bathroom = new Room("Bathroom");
    private final Room balcony = new Room("Balcony");
    private final Room storeroom = new Room("Storeroom");
    private final Room gym = new Room("Gym");
    private final Room livingroom = new Room("Livinngroom");
    private final Room secretroom = new Room("Secretroom");


    private final Items diamant1 = new Items(false);
    private final Items diamant2 = new Items(false);
    private final Items diamant3 = new Items(false);
    private final Items diamant4 = new Items(false);
    private final Items diamant5 = new Items(false);
    private final Items diamant6 = new Items(false);

    private final Items trap1 = new Items(true);
    private final Items trap2 = new Items(true);
    private final Items trap3 = new Items(true);

    public void addItems(){
           office.getItemsArrayList().add(diamant1);
           kitchen.getItemsArrayList().add(trap1);
           bedroom.getItemsArrayList().add(diamant2);
           toilett.getItemsArrayList().add(diamant3);
           bathroom.getItemsArrayList().add(diamant4);
           balcony.getItemsArrayList().add(diamant5);
           livingroom.getItemsArrayList().add(diamant6);
           gym.getItemsArrayList().add(trap2);
           storeroom.getItemsArrayList().add(trap3);
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
