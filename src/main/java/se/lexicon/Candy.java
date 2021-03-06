package se.lexicon;

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
        return "Open your package of " + name + " and enjoy every bite of it. WARNING! " +
                "If you have a nut allergy, make sure to choose a product which does not contain nuts.";
    }

    @Override
    public String toString() {
        return "Product number: " + getPRODUCTNUMBER() + ". Name: " + name + ". " +
                "Price: " + price + "SEK. It contains " +
                + sugarPercent + " percent of sugar.";
    }

    public int getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(int sugarPercent) {
        this.sugarPercent = sugarPercent;
    }
}
