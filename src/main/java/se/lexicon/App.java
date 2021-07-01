package se.lexicon;

import sun.management.snmp.jvminstr.JvmOSImpl;

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



       newVendingMachineImpl.welcomeAddFunds();

       newVendingMachineImpl.printOutProductsListBuy();

       //newVendingMachineImpl.continueOrNot();



        //System.out.println(chosenProduct.use());













    }
}
