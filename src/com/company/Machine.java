package com.company;

public class Machine {
    int waterNeed = Drink.getWaterNeed();
    int coffeeNeed = Drink.getCoffeeNeed();
    static int coffeeHave = (int) (Math.random() * 600);
    static int waterHave = (int) (Math.random() * 1500);
    Drink coffee = new Drink(250, 30);

    public static void Use(int coffeeHave, int waterHave, int waterNeed, int coffeeNeed) {
        coffeeHave -= coffeeNeed;
        waterHave -= waterNeed;
    }
    public static int getCoffeeHave() {
        return coffeeHave;
    }
    public static int getWaterHave() {
        return waterHave;
    }
}
