package se.lexicon;

public class Drinks extends Product {

    String volume;

    public Drinks(String name, int price, String volume) {
        super(name, price);
        this.volume = volume;
    }

    Drinks newDrink;


    String examine(){
        return getName();
    }

    @Override
    public Product purchase(int money){
    return newDrink;
    }

    @Override
    public void use(){
    }


}
