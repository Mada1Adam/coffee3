package com.company;

import java.util.Scanner;

class Machine { //правило yangi
    private int coffeeHave;
    private int waterHave;
    private final Drink coffee;
    private final Scanner scanner;

    Machine() {
        coffeeHave = (int) (Math.random() * 800);
        waterHave = (int) (Math.random() * 1500);
        coffee = new Drink(250, 30);
        scanner = new Scanner(System.in);
    }

     void cook() { //сохранить и сначала ВСЕ
        printCoffeeHave(coffeeHave, waterHave);
        while (true) {
            printAskCoffee();
            String input = scanner.nextLine();
            if (checkIfEnoughIngredients(input, coffee.waterNeed(), coffee.coffeeNeed())) {
                cookCoffee(coffee.waterNeed(), coffee.coffeeNeed());
            } else if (!checkInput(input)) {
                showMessage("Wrong input, please try again");
            } else if (checkIfPoliteAndEnoughIngredients(input)) {
                showMessage("Have a nice day, goodbye");
                break;
            } else if (isEnoughIngredientsToCookCoffee()) {
                askAdd(coffee.waterNeed(), coffee.coffeeNeed());
            } else {
                showMessage("Goodbye");
                break;
            }
        }
    }

    private void addIngredients() {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Yes, please")) {
            this.coffeeHave += 450;
            this.waterHave += 850;
        }
    }

    private void useIngredients(int waterNeed, int coffeeNeed) {
        this.coffeeHave -= coffeeNeed;
        this.waterHave -= waterNeed;
    }

    private boolean checkInput(String input) {
        return input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("No, thanks") || input.equalsIgnoreCase("No"); //letters y or n
    }

    private void printAskCoffee() {
        String someCoffee = """
                Some coffee?
                Type 'y' for yes ir 'n' for no
                """;
        showMessage(someCoffee);
    }

    private void printCoffeeHave(int coffeeHave, int waterHave) {
        showMessage(String.format("Coffee you have: %d", coffeeHave));
        showMessage(String.format("Water you have: %d", waterHave));
    }

    private boolean checkIfEnoughIngredients(String input, int coffeeNeed, int waterNeed) { //Change, don't check input
        return input.equalsIgnoreCase("y")
                && coffeeNeed < coffeeHave
                && waterNeed < waterHave;
    }

    private void cookCoffee(int waterNeed, int coffeeNeed) {
        useIngredients(waterNeed, coffeeNeed);
        showMessage("""
                Here is your coffee:
                ┈┈┈┈┈┈♡┈┈┈┈
                ┈┈┈┈┈╭╯♡┈┈┈
                ┈┈╱▔╭╯▔╲┈┈┈
                ┈▕╲▂▂▂▂╱▏┈┈
                ┈┈▏┊┊┊┊▕━╮┈
                ┈┈▏┊┊┊┊▕┈┃┈
                ┈┈▏┊┊┊┊▕━╯┈
                ┈┈╲▂▂▂▂╱┈┈┈
                """);
    }

    private void askAdd(int waterNeed, int coffeeNeed) {
        showMessage("Not enough ingredients, add?");
        addIngredients();
        showMessage(String.format("Coffee: %d water: %d coffee?", coffeeHave, waterHave));
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Yes")){
            cookCoffee(waterNeed, coffeeNeed);
        } else {
            showMessage("Wrong input"); //Change, too much
        }
    }

    private void showMessage(String message) {
        System.out.println(message);
    }

    private boolean checkIfPoliteAndEnoughIngredients(String input) { //Change, if = is
        return input.equalsIgnoreCase("No, thanks")
                && coffee.coffeeNeed() < coffeeHave
                && coffee.coffeeNeed() < waterHave;
    }

    private boolean isEnoughIngredientsToCookCoffee() { 
        return coffee.coffeeNeed() > coffeeHave
                || coffee.waterNeed() > waterHave;
    }
}
