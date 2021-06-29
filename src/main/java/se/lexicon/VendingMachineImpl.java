package se.lexicon;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;

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
                } if(moneyPool < product.getPrice()){
                    System.out.println("You don not have enough funds. Please add more funds to your account.");
                    System.out.println("-----------------------------------------------------------------------------------");
                    welcomeAddFunds();
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

    public void welcomeAddFunds() {
        System.out.println("Welcome! Please add funds to your account.");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Please choose the amount you would like to add to your account:");
        System.out.println("SEK1, SEK2, SEK5, SEK10, SEK20, SEK50, SEK100, SEK200, SEK500, SEK1000. Then push enter.");

        Scanner scanner = new Scanner(System.in);
        String moneyToAdd = scanner.next();
        addCurrency(Denominations.valueOf(moneyToAdd));
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Your new balance is: " + getBalance() + "SEK.");
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void printOutProductsListBuy() {
        System.out.println("Those are the products available for the moment.");
        System.out.println("-----------------------------------------------------------------------------------");
        for (String s : getProducts()) {
            System.out.println(s);
        }

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Please press the number corresponding to the product you would like to buy, and press enter.");

        Scanner scanner = new Scanner(System.in);
        int chosenProduct = scanner.nextInt();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("You chose:");
        System.out.println(getDescription(chosenProduct));
        System.out.println("-----------------------------------------------------------------------------------");

        boolean answer = true;
        while (answer) {
            System.out.println("Would you like to purchase the product? Push " + 1 + " for yes or " + 2 + " for no.");
            int test = scanner.nextInt();
            System.out.println("-----------------------------------------------------------------------------------");
            if (test == 2) {
                printOutProductsListBuy();
                answer = false;
            }
            if (test == 1) {
                answer = false;
                Product boughtProduct = request(chosenProduct);
                System.out.println("Here is your " + boughtProduct.getName() + "!");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println(boughtProduct.use());
                System.out.println("-----------------------------------------------------------------------------------");
            }
            if (test != 1 && test != 2) {
                System.out.println("Your choice is not valid. Please choose 1 or 2.");
                answer = true;
            }
        }
    }


    public void continueOrNot(){
        System.out.println("Would you like to continue buying?");
        System.out.println("Press " + 1 + " for yes, or " + 2 + " for ending session.");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if(answer==1){
            printOutProductsListBuy();
        } if(answer==2){
            endSession();
        }
    }




}
