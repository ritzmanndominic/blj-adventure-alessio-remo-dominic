package com.company;

public class Items {
    private boolean alarm;

    public Items(){}

    public Items(boolean alarm) {
        this.alarm = alarm;
    }

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

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    public Items getDiamant1() {
        return diamant1;
    }

    public void setDiamant1(Items diamant1) {
        this.diamant1 = diamant1;
    }

    public Items getDiamant2() {
        return diamant2;
    }

    public void setDiamant2(Items diamant2) {
        this.diamant2 = diamant2;
    }

    public Items getDiamant3() {
        return diamant3;
    }

    public void setDiamant3(Items diamant3) {
        this.diamant3 = diamant3;
    }

    public Items getDiamant4() {
        return diamant4;
    }

    public void setDiamant4(Items diamant4) {
        this.diamant4 = diamant4;
    }

    public Items getDiamant5() {
        return diamant5;
    }

    public void setDiamant5(Items diamant5) {
        this.diamant5 = diamant5;
    }

    public Items getDiamant6() {
        return diamant6;
    }

    public void setDiamant6(Items diamant6) {
        this.diamant6 = diamant6;
    }

    public Items getDiamant7() {
        return diamant7;
    }

    public void setDiamant7(Items diamant7) {
        this.diamant7 = diamant7;
    }

    public Items getTrap1() {
        return trap1;
    }

    public void setTrap1(Items trap1) {
        this.trap1 = trap1;
    }

    public Items getTrap2() {
        return trap2;
    }

    public void setTrap2(Items trap2) {
        this.trap2 = trap2;
    }

    public Items getTrap3() {
        return trap3;
    }

    public void setTrap3(Items trap3) {
        this.trap3 = trap3;
    }
}
