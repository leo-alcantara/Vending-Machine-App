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
        return "Drink: " +
                "name: " + name + " " +
                "price: " + price + " and " +
                "volume: " + volume +
                ".";
    }

    public String useToString() {
        return "Open the can of your " + name + " and enjoy every sip of it.";
    }







}
