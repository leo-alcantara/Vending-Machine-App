package se.lexicon;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

import static se.lexicon.Denominations.SEK1;

public class VendingMachineImpl implements VendingMachine {
    //Fields

    Product[] products;
    int moneyPool;

    //Constructors
    public VendingMachineImpl() {
        this.products = new Product[0];
        this.moneyPool = 0;
    }

    //Instantiations
    Denominations newDenominations;

    //Methods
    @Override
    public void addCurrency(Denominations money) {
        switch (money) {
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
                    int productCost = product.getPrice();
                    moneyPool = moneyPool - productCost;
                    boughtProduct = product;
                    //System.out.println(boughtProduct);
                }
            }
        }
        return boughtProduct;

    }

    @Override
    public int endSession() {
        System.out.println("Your change is " + moneyPool + ". Thank you for buying our products.");
        int change = moneyPool;
        moneyPool = 0;
        return change;
    }

    @Override
    public String getDescription(int productNumber) {
        String productsDescription = null;
        for (Product product : products) {
            if (product.getPRODUCTNUMBER() == productNumber) {
                productsDescription = product.examine();
            }
        }
        return productsDescription;
    }


    @Override
    public int getBalance() {
        System.out.println("Your new balance is: ");
        return moneyPool;
    }


    @Override
    public String[] getProducts() {
        String[] allProducts = {};
        for (Product product : products) {
            allProducts = Arrays.copyOf(allProducts, allProducts.length + 1);
            allProducts[allProducts.length - 1] = product.examine();
            //System.out.println(Arrays.toString(allProducts));
        }
        return allProducts;
    }


    public Drinks createNewDrinks(String name, String description, int price, String volume) {
        Drinks newDrinks = new Drinks(name, description, price, volume);
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = newDrinks;
        return newDrinks;
    }

    public Snacks createNewSnack(String name, String description, int price, int calories) {
        Snacks newSnack = new Snacks(name, description, price, calories);
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = newSnack;
        return newSnack;
    }

    public Candy createNewCandy(String name, String description, int price, int sugarPercent) {
        Candy newCandy = new Candy(name, description, price, sugarPercent);
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = newCandy;
        return newCandy;
    }


}
