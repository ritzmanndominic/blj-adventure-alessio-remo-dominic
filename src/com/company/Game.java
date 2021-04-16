package com.company;

public class Game {
    Room office = new Room("Office");

    Items diamant1 = new Items(false);
    Items diamant2 = new Items(false);
    Items diamant3 = new Items(false);
    Items diamant4 = new Items(false);
    Items diamant5 = new Items(false);
    Items diamant6 = new Items(false);
    Items diamant7 = new Items(false);

    Items trap1 = new Items(true);
    Items trap2 = new Items(true);
    Items trap3 = new Items(true);

    public void addItems(){
           office.getItemsArrayList().add(diamant1);
    }
}
