package com.company;

import java.util.Scanner;

public class Machine {
    int coffeeHave = (int) (Math.random() * 800);
    int waterHave = (int) (Math.random() * 1500);
    Drink coffee = new Drink(250, 30);
    Scanner scan = new Scanner(System.in);
    public void cooking(){
        print();
        String word = scan.nextLine();
            while (true) {
                //word.equals("yes") && coffee.getCoffeeNeed() < coffeeHave && coffee.getWaterNeed() < waterHave
                if (check()) {
                    use(coffee.getWaterNeed(), coffee.getCoffeeNeed());
                    System.out.println("Here is ur coffee");
                    System.out.println("More coffee?");
                    word = scan.nextLine();
                } else if(word.equals("no, thx") || coffee.getCoffeeNeed() < coffeeHave || coffee.getWaterNeed() < waterHave) {
                    System.out.println("Have a nice day, goodbye, Honey Bear");
                    break;
                } else if (coffee.getCoffeeNeed() > coffeeHave || coffee.getWaterNeed() > waterHave) {
                    System.out.println("Not enough ingredients, looser, add them?");
                    adding();
                    System.out.println("coffee: " + coffeeHave + "water: " + waterHave + " coffee? " );
                    word = scan.nextLine();
                    if (word.equals("yes")){
                        use(coffee.getWaterNeed(), coffee.getCoffeeNeed());
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Goodbye, asshole");
                    break;
                }
            }
    }
    public void adding(){
        String wordAdd = scan.nextLine();
        if(wordAdd.equals("yes, please")) {
            this.coffeeHave += 450;
            this.waterHave += 850;
        }
    }
    public void print(){
        System.out.println("coffee u have: " + coffeeHave);
        System.out.println("water u have: " + waterHave);
        System.out.println("Hello, some coffee?");

    }
    public void use(int waterNeed, int coffeeNeed) {
        this.coffeeHave -= coffeeNeed;
        this.waterHave -= waterNeed;
    }
    public boolean check(){
        boolean yesOrNo;
        String word1 = scan.nextLine();
        yesOrNo = word1.equals("yes") && coffee.getCoffeeNeed() < coffeeHave && coffee.getWaterNeed() < waterHave;
        return yesOrNo;
    }
}
