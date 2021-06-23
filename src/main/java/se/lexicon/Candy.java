package se.lexicon;

public class Candy extends Product {

    int sugarPercent;

    public Candy(String name, int price, int sugarPercent) {
        super(name, price);
        this.sugarPercent = sugarPercent;
    }

    Candy newCandy;

    String examine(){
        return getName();
    }

    @Override
    public Product purchase(int money){
        return newCandy;

    }

    @Override
    public void use(){


    }





}
