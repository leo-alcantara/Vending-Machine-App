package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;
import static se.lexicon.Denominations.SEK100;


public class App {

    public static void main( String[] args ) {

        Denominations newDenominations;

        Scanner scanner = new Scanner(System.in);

        Drinks newDrink;
        Snacks newSnack;
        Candy newCandy;

        VendingMachineImpl newVendingMachineImpl = new VendingMachineImpl();

        newVendingMachineImpl.createNewDrinks("Sprite", "Lemon Soda Drink", 15, "330 ml");
        newVendingMachineImpl.createNewDrinks("Fanta", "Orange Soda Drink", 15, "330 ml");
        newVendingMachineImpl.createNewDrinks("Coke", "Cola Soda Drink", 15, "330 ml");
        newVendingMachineImpl.createNewSnack("Lays", "Potato Chips", 20, 120);
        newVendingMachineImpl.createNewSnack("Cheese Doodles", "Cheese Flavoured Snack", 25, 130);
        newVendingMachineImpl.createNewSnack("Lentil Chips", "Lentil Healthy Chips", 30, 85);
        newVendingMachineImpl.createNewCandy("Snickers", "Chocolate Bar", 15, 65);
        newVendingMachineImpl.createNewCandy("Mars Bars", "Chocolate Bar", 15, 65);
        newVendingMachineImpl.createNewCandy("Milky Way", "Chocolate Bar", 15, 65);

        //System.out.println(newVendingMachineImpl.products[5].getPRODUCTNUMBER());

        System.out.println("Welcome! Please add your funds and choose the product you would like to consume.");

        System.out.println("Please choose the amount you would like to add to your account: SEK1, SEK2, SEK5, SEK10, SEK20, SEK50, SEK100, SEK200, SEK500, SEK1000. Then push enter.");

        String moneyToAdd = scanner.next();
        newVendingMachineImpl.addCurrency(Denominations.valueOf(moneyToAdd));

        //System.out.println("Your new balance is " + newVendingMachineImpl.moneyPool + " SEK.");
        System.out.println(newVendingMachineImpl.getBalance());

        System.out.println("Those are the products available for the moment.");

        for (String s: newVendingMachineImpl.getProducts()) {
            System.out.println(s);
        }



        System.out.println("Please press the number of the product you would like to consume and press enter.");


        int chosenProduct = scanner.nextInt();
        System.out.println("You chose the Product:");
        System.out.println(newVendingMachineImpl.getDescription(chosenProduct));

       // chosenProduct = newDrink.getPRODUCTNUMBER();




        boolean answer = true;
        while (answer) {
            System.out.println("Would you like to purchase the product? Push " + 1 + " for yes or " + 2 + " for no.");
            int test = scanner.nextInt();
            if (test == 2) {
                System.out.println(Arrays.toString(newVendingMachineImpl.getProducts()));
                answer = false;
            }
            if (test == 1) {
                answer = false;
                Product boughtProduct = newVendingMachineImpl.request(chosenProduct);
                System.out.println(boughtProduct.use());
            }
            if (test != 1 && test != 2) {
                System.out.println("Your choice is not valid. Please choose 1 or 2.");
                answer = true;
            }
        }

        newVendingMachineImpl.endSession();


        //System.out.println(chosenProduct.use());













    }
}
