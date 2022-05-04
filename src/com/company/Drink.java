package com.company;

class Drink {
    private final int coffeeNeed;
    private final int waterNeed;
    
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
