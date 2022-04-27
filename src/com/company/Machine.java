package com.company;

import java.util.Scanner;

class Machine {
    private int coffeeHave = 1; //(int) (Math.random() * 800);
    private int waterHave = 1; //(int) (Math.random() * 1500);

    Drink coffee = new Drink(250, 30);
    Scanner scanner = new Scanner(System.in);
    void cook(){
        printCoffeeHave(coffeeHave, waterHave);
            while (true) {
                printAskCoffee();
                String input = scanner.nextLine();
                if (checkIfEnoughIngredient(input, coffee.getWaterNeed(), coffee.getCoffeeNeed())) {
                    cookCoffee(coffee.getWaterNeed(), coffee.getCoffeeNeed());
                } else if (!checkInput(input)) {
                    System.out.println("wrong input, please try again");
                } else if (input.equals("no, thx") && coffee.getCoffeeNeed() <
                        coffeeHave && coffee.getWaterNeed() < waterHave) {
                    System.out.println("Have a nice day, goodbye, Honey Bear");
                    break;
                } else if (coffee.getCoffeeNeed() > coffeeHave || coffee.getWaterNeed() > waterHave) {
                    askAdd(coffee.getWaterNeed(), coffee.getCoffeeNeed());
                } else {
                    System.out.println("Goodbye, asshole");
                    break;
                }
            }
    }
    public void addIngredient() {
        String wordAdd = scanner.nextLine();
        if(wordAdd.equals("yes, please")) {
            this.coffeeHave += 450;
            this.waterHave += 850;
        }
    }

    public void useIngredient(int waterNeed, int coffeeNeed) {
        this.coffeeHave -= coffeeNeed;
        this.waterHave -= waterNeed;
    }
    public boolean checkInput (String input) {
        return input.equals("yes") || input.equals("no, thx") || input.equals("no");
    }

    public void printAskCoffee() {
        System.out.println("Some coffee?");
        System.out.println("1. yes");
        System.out.println("2. no, thx");
    }

    public void printCoffeeHave(int coffeeHave, int waterHave) {
        System.out.printf("coffee u have: %s", coffeeHave);
        System.out.printf("water u have: %s", waterHave);
    }

    public boolean checkIfEnoughIngredient(String input, int coffeeNeed, int waterNeed) {
        boolean yesOrNo;
        yesOrNo = input.equals("yes") && coffeeNeed < coffeeHave && waterNeed < waterHave;
        return yesOrNo;
    }

    public void cookCoffee(int waterNeed, int coffeeNeed) {
        useIngredient(waterNeed, coffeeNeed);
        System.out.println("Here is ur coffee");
    }

    public void askAdd(int waterNeed, int coffeeNeed) {
        System.out.println("Not enough ingredients, looser, add?");
        addIngredient();
        System.out.println("coffee: " + coffeeHave + " water: " + waterHave + " coffee? " );
        String input = scanner.nextLine();
        if (input.equals("yes")){
            cookCoffee(waterNeed, coffeeNeed);
        } else {
            System.out.println("Wrong input");
        }
    }
}
