package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Hello, some coffee?");
            String word = scan.nextLine();
            if(word.equals("Yes")) {
                System.out.println("Here is ur coffee");
                Machine.Use(Machine.getCoffeeHave(), Machine.getWaterHave(), Drink.getWaterNeed(), Drink.getCoffeeNeed());
            } else {
                System.out.println("Have a nice day, goodbye");
                break;
            }
        }
    }
}
