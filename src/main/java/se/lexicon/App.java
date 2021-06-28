package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;


import static se.lexicon.Denominations.SEK100;


public class App {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        Drinks newDrink = null;
        Snacks newSnack = null;
        Candy newCandy = null;

        VendingMachineImpl newVendingMachineImpl = new VendingMachineImpl();

        newVendingMachineImpl.createNewDrinks("Sprite", "Lemon Soda Drink", 40, "330 ml");
        newVendingMachineImpl.createNewDrinks("Fanta", "Orange Soda Drink", 40, "330 ml");
        newVendingMachineImpl.createNewDrinks("Coke", "Cola Soda Drink", 40, "330 ml");
        newVendingMachineImpl.createNewSnack("Lays", "Potato Chips", 30, 120);
        newVendingMachineImpl.createNewSnack("Cheese Doodles", "Cheese Flavoured Snack", 35, 130);
        newVendingMachineImpl.createNewSnack("Lentil Chips", "Lentil Healthy Chips", 40, 85);
        newVendingMachineImpl.createNewCandy("Snickers", "Chocolate Bar", 30, 65);
        newVendingMachineImpl.createNewCandy("Mars Bars", "Chocolate Bar", 25, 65);
        newVendingMachineImpl.createNewCandy("Milky Way", "Chocolate Bar", 20, 65);

        System.out.println(newVendingMachineImpl.products[0].getPRODUCTNUMBER());
        //System.out.println(chips.getPRODUCTNUMBER());
        //System.out.println(snickers.getPRODUCTNUMBER());

        System.out.println("Welcome! Please add you funds and choose the product you would like to consume.");

        System.out.println("Please choose the amount you would like to add to your account: SEK1, SEK2, SEK5, SEK10, SEK20, SEK50, SEK100, SEK200, SEK500, SEK1000.");

        String moneyToAdd = scanner.next(); //get int convert to valueof();
        newVendingMachineImpl.addCurrency(Denominations.valueOf(moneyToAdd));

        System.out.println("Your new balance is " + newVendingMachineImpl.moneyPool);

        System.out.println(Arrays.toString(newVendingMachineImpl.getProducts()));

        System.out.println("Please press the number of the product you would like to consume.");

        int chosenProduct = scanner.nextInt();
        System.out.println(newVendingMachineImpl.getDescription(chosenProduct));

        //Is the chosenProduct a drink? or Snack...

        System.out.println("Would you like to purchase the " + newCandy.getName());

        boolean answer = true;
        while (answer) {
            System.out.println("Would you like to purchase the " +  " product? Push " + 1  + " for yes or " + 2 + " for no.");
            int test = scanner.nextInt();
            if (test == 2) {
                System.out.println(Arrays.toString(newVendingMachineImpl.getProducts()));
                answer = false;
            }
            if (test == 1) {
                answer = false;
                System.out.println(newVendingMachineImpl.request(chosenProduct));
            }
            if (test != 1 && test != 2) {
                System.out.println("Your choice is not valid. Please choose 1 or 2.");
                answer = true;
            }
        }



        newVendingMachineImpl.request(2);

        newVendingMachineImpl.getDescription(5);

        newVendingMachineImpl.request(5);

        newVendingMachineImpl.getDescription(9);

        newVendingMachineImpl.request(9);










    }
}
