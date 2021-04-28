package com.company;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class StoreScore {

    public static void saveData(String fileWriteTo, Player player, Game game) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        Date date = new Date();
        Timestamp currentTime = new Timestamp(date.getTime());

        arrayList.add(game.getRooms().get(game.getActiveRoom()).getName());
        arrayList.add(String.valueOf(player.getLives()));

        arrayList.add(String.valueOf((currentTime.getTime() - player.getStartTime().getTime() + player.getGameTime())));

        for (int i = 0; i < game.getRooms().size(); i++) {
            for (int j = 0; j < game.getRooms().get(i).getItemsArrayList().size(); j++) {
                arrayList.add(game.getRooms().get(i).getItemsArrayList().get(j).getName());
            }
        }

        for (int i = 0; i < player.getItemList().size(); i++) {
            arrayList.add(player.getItemList().get(i).getName());
        }

        FileOutputStream fos = new FileOutputStream(fileWriteTo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(arrayList);
        oos.close();
    }

    public static void loadData(String fileToReadForm, Player player, Game game) throws Exception {
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
        player.setLives(Integer.parseInt(arrayList.get(1)));

        //set game time
        player.setGameTime(Long.parseLong(arrayList.get(2)));

        //set empty room
        for (int i = 3; i < 13; i++) {
            if (arrayList.get(i).isEmpty()) {
                game.getRooms().get(i).setItemsArrayList(null);
            }
        }

        //remove
        for (int i = 0; i < 13; i++) {
            arrayList.remove(0);
        }

        //set item list
        for (int j = 0; j < game.getItems().size(); j++) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).equals(game.getItems().get(j).getName())) {
                    player.getItemList().add(game.getItems().get(i));
                }
            }
        }
    }
}
