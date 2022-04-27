package com.company;

public class Drink {
    private int coffeeNeed;
    private int waterNeed;
    
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
