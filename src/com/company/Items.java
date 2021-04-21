package com.company;

public class Items {
    private String name;
    private boolean alarm;

    public Items() {
    }

    public Items(String name, boolean alarm) {
        this.name = name;
        this.alarm = alarm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }
}