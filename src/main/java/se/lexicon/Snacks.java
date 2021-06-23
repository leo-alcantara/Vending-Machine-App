package se.lexicon;

public class Snacks extends Product {

    int calories;

    public Snacks(String name, int price, int calories) {
        super(name, price);
        this.calories = calories;
    }

    Snacks newSnacks;

    String examine(){
        return getName();
    }

    @Override
    public Product purchase(int money){
        return newSnacks;

    }

    @Override
    public void use(){


    }



}
