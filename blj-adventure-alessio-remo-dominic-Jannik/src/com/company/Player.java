package com.company;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Player {
    private ArrayList<Items> itemList;
    private int lives;
    private int maxLives;
    private long gameTime;
    private Timestamp startTime;

    public Player(int lives) {
        this.itemList = new ArrayList<>();
        this.lives = lives;
        this.maxLives = lives;

        gameTime = 0;
        Date date = new Date();
        startTime = new Timestamp(date.getTime());
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public long getGameTime() {
        return gameTime;
    }

    public void setGameTime(long gameTime) {
        this.gameTime = gameTime;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public ArrayList<Items> getItemList() {
        return itemList;
    }

    public int getMaxLives() {
        return maxLives;
    }
}