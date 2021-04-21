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

    public static void readObject(String fileToReadForm) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileToReadForm);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<String> arrayList = (ArrayList<String>) ois.readObject();
        ois.close();

        for (String entry : arrayList){
            System.out.println(entry);
        }
    }
}
