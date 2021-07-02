package se.lexicon;

public class ProductSequencer {

    private static int sequencer = 0;

    public static int nextProductNumber(){
        return ++sequencer;
    }

    public static void resetSequencer(){
        sequencer = 0;
    }

}
