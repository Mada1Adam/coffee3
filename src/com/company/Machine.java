package com.company;

import java.util.Scanner;

class Machine {
    private int coffeeHave = (int) (Math.random() * 800);
    private int waterHave = (int) (Math.random() * 1500);

    private Drink coffee = new Drink(250, 30);

    private Scanner scanner = new Scanner(System.in);
    void cook(){
        printCoffeeHave(coffeeHave, waterHave);
            while (true) {
                printAskCoffee();
                String input = scanner.nextLine();
                if (checkIfEnoughIngredient(input, coffee.getWaterNeed(), coffee.getCoffeeNeed())) {
                    cookCoffee(coffee.getWaterNeed(), coffee.getCoffeeNeed());
                } else if (!checkInput(input)) {
                    showMessage("wrong input, please try again");
                } else if (checkIfPolite(input)) {
                    showMessage("Have a nice day, goodbye, Honey Bear");
                    break;
                } else if (checkIfAdd()) {
                    askAdd(coffee.getWaterNeed(), coffee.getCoffeeNeed());
                } else {
                    showMessage("Goodbye, asshole");
                    break;
                }
            }
    }
    void addIngredient() {
        String wordAdd = scanner.nextLine();
        if (wordAdd.equals("yes, please")) {
            this.coffeeHave += 450;
            this.waterHave += 850;
        }
    }

    void useIngredient(int waterNeed, int coffeeNeed) {
        this.coffeeHave -= coffeeNeed;
        this.waterHave -= waterNeed;
    }
    boolean checkInput (String input) {
        return input.equals("yes") || input.equals("no, thx") || input.equals("no");
    }

    void printAskCoffee() {
        String someCoffee = """
                some coffee?
                1. yes
                2. no, thx
                """;
        showMessage(someCoffee);
    }

    void printCoffeeHave(int coffeeHave, int waterHave) {
        showMessage(String.format("coffee u have: %d", coffeeHave));
        showMessage(String.format("watter u have: %d", waterHave));
    }

    boolean checkIfEnoughIngredient(String input, int coffeeNeed, int waterNeed) {
        return input.equals("yes") && coffeeNeed < coffeeHave && waterNeed < waterHave;
    }

    void cookCoffee(int waterNeed, int coffeeNeed) {
        useIngredient(waterNeed, coffeeNeed);
        showMessage("Here is ur coffee");
    }

    void askAdd(int waterNeed, int coffeeNeed) {
        showMessage("Not enough ingredients, looser, add?");
        addIngredient();
        showMessage(String.format("coffee: %d water: %d coffee?", coffeeHave, waterHave));
        String input = scanner.nextLine();
        if (input.equals("yes")){
            cookCoffee(waterNeed, coffeeNeed);
        } else {
            showMessage("Wrong input");
        }
    }
    void showMessage(String message) {
        System.out.println(message);
    }
    boolean checkIfPolite(String input) {
        return input.equals("no, thx") && coffee.getCoffeeNeed() < coffeeHave && coffee.getWaterNeed() < waterHave;
    }
    boolean checkIfAdd() {
        return coffee.getCoffeeNeed() > coffeeHave || coffee.getWaterNeed() > waterHave;
    }
}
