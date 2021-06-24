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
    public void use() {
        useToString();
    }

    @Override
    public String toString() {
        return "Candy: " +
                "name: " + name + ", " +
                "price: " + price + " and " +
                "sugarPercent: " + sugarPercent +
                ".";
    }

    public String useToString() {
        return "Open the package of your " + name + " and enjoy every bite of it. WARNING! " +
                "If you have a nut allergy, make sure to choose a product which does not contain nuts.";
    }


}
