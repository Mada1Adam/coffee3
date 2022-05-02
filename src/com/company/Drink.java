package com.company;

public class Drink {
    private int coffeeNeed;
    private int waterNeed;
    
    Drink(int waterNeed, int coffeeNeed) {
        this.coffeeNeed = coffeeNeed;
        this.waterNeed = waterNeed;
    }

    int getCoffeeNeed() {
        return coffeeNeed;
    }

    int getWaterNeed() {
        return waterNeed;
    }
}
