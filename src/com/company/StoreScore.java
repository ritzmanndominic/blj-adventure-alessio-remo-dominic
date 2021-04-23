package com.company;

import java.io.*;
import java.util.ArrayList;

public class StoreScore {

    public static void saveObject(String fileWriteTo, Player player1, Game game) throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();
        String lives = String.valueOf(player1.getLives());

        arrayList.add(game.getRooms().get(game.getActiveRoom()).getName());
        arrayList.add(lives);

        for (int i = 0; i < game.getRooms().size(); i++) {
            for (int j = 0; j < game.getRooms().get(i).getItemsArrayList().size(); j++) {
                arrayList.add(game.getRooms().get(i).getItemsArrayList().get(j).getName());
            }
        }

        for (int i=0; i < player1.getItemList().size(); i++){
            arrayList.add(player1.getItemList().get(i).getName());
        }

        FileOutputStream fos = new FileOutputStream(fileWriteTo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(arrayList);
        oos.close();
    }

    public static void loadData(String fileToReadForm, Player player1, Game game) throws Exception {
        int activeRoom = 0;
        FileInputStream fis = new FileInputStream(fileToReadForm);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        ois.close();

        //set active room
        for (int i = 0; i < game.getRooms().size(); i++) {
            if (arrayList.get(0).equals(game.getRooms().get(i).getName())) {
                activeRoom = i;
            }
        }
        game.setActiveRoom(activeRoom);

        //set lives
        player1.setLives(Integer.parseInt(arrayList.get(1)));

        //set empty room
        for (int i = 2; i < 12; i++) {
            if (arrayList.get(i).isEmpty()){
                game.getRooms().get(i).setItemsArrayList(null);
            }
        }

        //remove
        for (int i = 0; i < 12; i++) {
            arrayList.remove(0);
        }

        //set item list
        for (int j = 0; j < game.getItems().size(); j++) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).equals(game.getItems().get(j).getName())) {
                    player1.getItemList().add(game.getItems().get(i));
                }
            }
        }

    }
}
