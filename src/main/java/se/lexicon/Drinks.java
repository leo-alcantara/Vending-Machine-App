package se.lexicon;

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
    public String use(){
        return "Open your can of " + name + " and enjoy every sip of it.";
    }

    @Override
    public String toString() {
        return "Product number: " + getPRODUCTNUMBER() + ". Name: " + name +
                ". Price: " + price + "SEK. It has " +
                volume + ".";
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
