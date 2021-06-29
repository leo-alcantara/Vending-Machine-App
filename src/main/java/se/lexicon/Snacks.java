package se.lexicon;

import java.util.Arrays;

public class Snacks extends Product {

    //Fields
    int calories;

    //Constructors
    public Snacks(String name, String description, int price, int calories) {
        super(name, description, price);
        this.calories = calories;
    }

    //Methods
    String examine(){
        return toString();
    }

    @Override
    public String use(){
        return "Open the package of your " + name + " and enjoy every bite of it. WARNING! " +
                "If you have a nut allergy, make sure to choose a product which does not contain nuts.";
    }

    @Override
    public String toString() {
        return "Product number: " + getPRODUCTNUMBER() + ". Name: " + name + ". " +
                "Price: " + price + "SEK. It contains " +
                 + calories + " calories.";
    }






}
