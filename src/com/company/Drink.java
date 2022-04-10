package com.company;

public class Drink {
     int coffeeNeed;
     int waterNeed;
    public Drink(int waterNeed, int coffeeNeed) {
        this.coffeeNeed = coffeeNeed;
        this.waterNeed = waterNeed;
    }
    public int getCoffeeNeed() {
        return coffeeNeed;
    }
    public int getWaterNeed() {
        return waterNeed;
    }
}
