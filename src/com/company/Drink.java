package com.company;

public class Drink {
    static int coffeeNeed;
    static int waterNeed;
    public Drink(int waterNeed, int coffeeNeed) {
        this.coffeeNeed = coffeeNeed;
        this.waterNeed = waterNeed;
    }
    public static int getCoffeeNeed() {
        return coffeeNeed;
    }
    public static int getWaterNeed() {
        return waterNeed;
    }
}
