package se.lexicon;

public interface VendingMachine {

    void addCurrency(Denominations money);
    Product request(int productNumber);
    int endSession();
    String getDescription(int productNumber);
    int getBalance();
    String[] getProducts();

}
