package se.lexicon;

public class ProductSequencer {

    private static int productNumber;

    public static int nextProductNumber(){
        int sequencer = 0;
        productNumber = ++sequencer;
        return productNumber;
    }

}
