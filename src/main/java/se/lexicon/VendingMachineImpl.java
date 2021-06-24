package se.lexicon;
import java.util.Arrays;

import static se.lexicon.Denominations.SEK1;

public class VendingMachineImpl implements VendingMachine {
    //Fields

    Product[] products;
    int moneyPool;

    //Constructors
    public VendingMachineImpl(Product[] products, int moneyPool) {
        this.products = products;
        this.moneyPool = moneyPool;
    }

    //Instantiations
    Denominations newDenominations;


    //Methods
    @Override
    public void addCurrency(Denominations money) {
        switch (money){
            case SEK1:
            case SEK2:
            case SEK5:
            case SEK10:
            case SEK20:
            case SEK50:
            case SEK100:
            case SEK200:
            case SEK500:
            case SEK1000:
                moneyPool = moneyPool + money.getValue();
               break;
            default:

        }

    }

    @Override
    public Product request(int productNumber) {
        Product boughtProduct = null;
        for (Product product : products) {
            if (product.getPRODUCTNUMBER() == productNumber) {
                if (moneyPool >= product.getPrice()) {
                    int drinkCost = product.getPrice();
                    moneyPool = moneyPool - drinkCost;
                    boughtProduct = product;
                }
            }
        }
         return boughtProduct;
    }

    @Override
    public int endSession() {
        System.out.println("Your change is " + moneyPool + ". Thank you for buying our products.");
        moneyPool = 0;
        return moneyPool;
    }

    @Override
    public String getDescription(int productNumber) {
        String productsDescription = null;
        for (Product product : products) {
            if (product.getPRODUCTNUMBER() == productNumber) {
                product.use();
                productsDescription = product.getName();
                } else {
                    System.out.println("Product number not valid.");
                }
            }
        return productsDescription;
        }



    @Override
    public int getBalance() {
        return moneyPool;
    }


    @Override
    public String[] getProducts() {
        String[] allProducts = Arrays.copyOf(products, products.length, String[].class);
        return allProducts;

    }


}
