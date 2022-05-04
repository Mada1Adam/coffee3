package com.company;

import java.util.Scanner;

class Machine {
    private int coffeeHave;
    private int waterHave = (int) (Math.random() * 1500);

    //Machine coffeeHave = new Values();
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
                showMessage("Wrong input, please try again");
            } else if (checkIfPolite(input)) {
                showMessage("Have a nice day, goodbye");
                break;
            } else if (checkIfAdd()) {
                askAdd(coffee.getWaterNeed(), coffee.getCoffeeNeed());
            } else {
                showMessage("Goodbye");
                break;
            }
        }
    }

    private void addIngredient() {
        String wordAdd = scanner.nextLine();
        if (wordAdd.equals("Yes, please")) {
            this.coffeeHave += 450;
            this.waterHave += 850;
        }
    }

    private void useIngredient(int waterNeed, int coffeeNeed) {
        this.coffeeHave -= coffeeNeed;
        this.waterHave -= waterNeed;
    }

    private boolean checkInput (String input) {
        return input.equals("Yes") || input.equals("No, thanks") || input.equals("No");
    }

    private void printAskCoffee() {
        String someCoffee = """
                Some coffee?
                1. Yes
                2. No, thanks
                """;
        showMessage(someCoffee);
    }

    private void printCoffeeHave(int coffeeHave, int waterHave) {
        showMessage(String.format("Coffee you have: %d", coffeeHave));
        showMessage(String.format("Water you have: %d", waterHave));
    }

    private boolean checkIfEnoughIngredient(String input, int coffeeNeed, int waterNeed) {
        return input.equals("Yes") && coffeeNeed < coffeeHave && waterNeed < waterHave;
    }

    private void cookCoffee(int waterNeed, int coffeeNeed) {
        useIngredient(waterNeed, coffeeNeed);
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
        addIngredient();
        showMessage(String.format("Coffee: %d water: %d coffee?", coffeeHave, waterHave));
        String input = scanner.nextLine();
        if (input.equals("Yes")){
            cookCoffee(waterNeed, coffeeNeed);
        } else {
            showMessage("Wrong input");
        }
    }

    private void showMessage(String message) {
        System.out.println(message);
    }

    private boolean checkIfPolite(String input) {
        return input.equals("No, thanks") && coffee.getCoffeeNeed() < coffeeHave && coffee.getWaterNeed() < waterHave;
    }

    private boolean checkIfAdd() {
        return coffee.getCoffeeNeed() > coffeeHave || coffee.getWaterNeed() > waterHave;
    }
    /*Values(int num) {
         this.coffeeHave = (int) (Math.random() * 800);
    }*/
}
