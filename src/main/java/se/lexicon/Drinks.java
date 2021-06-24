package se.lexicon;

import java.util.Arrays;

public class Drinks extends Product {

    //Fields
    String volume;

    //Constructor
    public Drinks(String name, String description, int price, String volume) {
        super(name, description, price);
        this.volume = volume;
    }

    //Methods
    @Override
    String examine(){
        return toString();
    }

    @Override
    public void use(){
        useToString();
    }

    @Override
    public String toString() {
        return "Candy: " +
                "name: " + name + " " +
                "price: " + price + " and " +
                "volume: " + volume +
                ".";
    }

    public String useToString() {
        return "Open the can of your " + name + " and enjoy every sip of it.";
    }

    //public Drinks createNewDrinks (String name, String description, int price, String volume) {
    //    Drinks newDrinks = new Drinks(name, description, price, volume);
    //    newVendingMachineImpl.products = Arrays.copyOf(newVendingMachineImpl.products, newVendingMachineImpl.products.length + 1);
    //    newVendingMachineImpl.products[newVendingMachineImpl.products.length - 1] = newDrinks;
    //    return newDrinks;

    //}





}
