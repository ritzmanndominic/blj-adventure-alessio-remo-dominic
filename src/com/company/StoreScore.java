package com.company;

import java.io.*;
import java.util.ArrayList;

public class StoreScore {

    public static void saveObject(String fileWriteTo, Player player1, Game game) throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(game.getRooms().get(game.getActiveRoom()).getName());
        for (int i=0; i < player1.getItemList().size(); i++){
            arrayList.add(player1.getItemList().get(i).getName());
        }

        FileOutputStream fos = new FileOutputStream(fileWriteTo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(arrayList);
        oos.close();
    }

    public static void loadData(String fileToReadForm, Player player1, Game game) throws IOException, ClassNotFoundException {
        int activeRoom = 0;
        FileInputStream fis = new FileInputStream(fileToReadForm);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        ois.close();

        for (int i = 0; i < game.getRooms().size(); i++) {
            if (arrayList.get(0).equals(game.getRooms().get(i).getName())) {
                activeRoom = i;
            }
        }
        game.setActiveRoom(activeRoom);

        arrayList.remove(0);
        for (int j = 0; j < game.getItems().size(); j++) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).equals(game.getItems().get(j).getName())) {
                    player1.getItemList().add(game.getItems().get(i));
                }
            }
        }
    }
}
