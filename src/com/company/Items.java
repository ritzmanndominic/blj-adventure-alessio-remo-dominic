package com.company;

public class Items {
    private boolean alarm;

    public Items(){}

    public Items(boolean alarm) {
        this.alarm = alarm;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }
}
