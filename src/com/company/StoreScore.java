package com.company;

import java.io.*;
import java.util.ArrayList;

public class StoreScore {

    public static void saveObject(String fileWriteTo, Player player1, Game game) throws Exception{
        ArrayList<String> arrayListItems = new ArrayList<>();
        String lives = String.valueOf(player1.getLives());
        ArrayList<String> arrayListRooms = new ArrayList<>();

        arrayListItems.add(game.getRooms().get(game.getActiveRoom()).getName());
        for (int i=0; i < player1.getItemList().size(); i++){
            arrayListItems.add(player1.getItemList().get(i).getName());
        }

        for (int i = 0; i < game.getRooms().size(); i++) {
            for (int j = 0; j < game.getRooms().get(i).getItemsArrayList().size(); j++) {
                arrayListRooms.add(game.getRooms().get(i).getItemsArrayList().get(j).getName());
            }
        }

        FileOutputStream fos = new FileOutputStream(fileWriteTo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(lives);
        oos.writeObject(arrayListRooms);
        oos.writeObject(arrayListItems);
        oos.close();
    }

    public static void loadData(String fileToReadForm, Player player1, Game game) throws IOException, ClassNotFoundException {
        int activeRoom = 0;
        FileInputStream fis = new FileInputStream(fileToReadForm);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        ois.close();

        //set active room
        for (int i = 0; i < game.getRooms().size(); i++) {
            if (arrayList.get(11).equals(game.getRooms().get(i).getName())) {
                activeRoom = i;
            }
        }
        game.setActiveRoom(activeRoom);

        //set item list
        arrayList.remove(0);
        for (int j = 0; j < game.getItems().size(); j++) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).equals(game.getItems().get(j).getName())) {
                    player1.getItemList().add(game.getItems().get(i));
                }
            }
        }

        //set lives
        player1.setLives(Integer.parseInt(arrayList.get(0)));

        //set empty room
        for (int i = 1; i < 11; i++) {
            if (arrayList.get(i).isEmpty()){
               game.getRooms().get(i).setItemsArrayList(null);
            }
        }
    }
}
