package se.lexicon;

import java.util.Arrays;

public class Candy extends Product {
    //Fields
    int sugarPercent;

    //Constructor
    public Candy(String name, String description, int price, int sugarPercent) {
        super(name, description, price);
        this.sugarPercent = sugarPercent;
    }

    //Methods
    String examine() {
        return toString();
    }

    @Override
    public String use() {
        return "Open the package of your " + name + " and enjoy every bite of it. WARNING! " +
                "If you have a nut allergy, make sure to choose a product which does not contain nuts.";
    }

    @Override
    public String toString() {
        return "Product number: " + getPRODUCTNUMBER() + ". Name: " + name + ". " +
                "Price: " + price + "SEK. It contains " +
                + sugarPercent + " percent of sugar.";
    }


}
