package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class VendingMachineImpl implements VendingMachine {
    //Fields
    //String[] allProducts = {};
    Product[] products;
    int moneyPool;

    //Constructors
    public VendingMachineImpl() {
        this.products = new Product[0];
        this.moneyPool = 0;
    }

    //Methods
    @Override

        public void addCurrency (Denominations money){
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
                System.out.println("The currency you are trying to add is not valid. Please make sure you add a valid amount.");
        }
    }

    @Override
    public Product request(int productNumber) {
        Product boughtProduct = null;
        for (Product product : products) {
            if (product.getPRODUCTNUMBER() == productNumber) {
                if (moneyPool >= product.getPrice()) {
                    moneyPool = moneyPool - product.getPrice();
                    boughtProduct = product;
                    break;
                }
                else if (moneyPool < product.getPrice()) {
                    System.out.println("You do not have enough funds. Please add more funds to your account.");
                    System.out.println("-----------------------------------------------------------------------------------");
                    welcomeAddFunds();
                    continueOrNot();
                }
            }
        }
        return boughtProduct;
    }

    @Override
    public int endSession() {
        int change = moneyPool;
        System.out.println("Your change is " + moneyPool + "SEK. Thank you for buying our products.");
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
        //Try and catch here
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

        System.out.println("Would you like to purchase the product? Push " + 1 + " for yes or " + 2 + " for no.");

        boolean answer = true;
        while (answer) {
            int test = scanner.nextInt();
            System.out.println("-----------------------------------------------------------------------------------");
            if (test == 2) {
                continueOrNot();
                answer = false;
            }
            if (test == 1) {
                Product boughtProduct = request(chosenProduct);
                System.out.println("Here is your " + boughtProduct.getName() + "!");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println(boughtProduct.use());
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Your current balance is: " + getBalance() + "SEK");
                System.out.println("-----------------------------------------------------------------------------------");
                continueOrNot();
                answer = false;
            }
            if (test != 1 && test != 2) {
                System.out.println("Your choice is not valid. Please choose 1 or 2.");
                answer = true;
            }
        }

    }

    public void continueOrNot() {
        System.out.println("Would you like to continue buying?");
        System.out.println("Press " + 1 + " for yes, or " + 2 + " for ending session.");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == 1) {
            System.out.println("-----------------------------------------------------------------------------------");
            printOutProductsListBuy();
        }
        if (answer == 2) {
            System.out.println("-----------------------------------------------------------------------------------");
            endSession();
        }
    }

    public Denominations[] calcChange() {
        Denominations[] change = {};
        if (moneyPool < 1000 && moneyPool > 500) {
            change = Arrays.copyOf(change, change.length + 1);
            change[change.length - 1] = Denominations.valueOf("500");
            moneyPool = moneyPool - 500;
            if (moneyPool > 200) {
                change = Arrays.copyOf(change, change.length + 1);
                change[change.length - 1] = Denominations.valueOf("200");
                moneyPool = moneyPool - 200;
                if (moneyPool > 100) {
                    change = Arrays.copyOf(change, change.length + 1);
                    change[change.length - 1] = Denominations.valueOf("100");
                    moneyPool = moneyPool - 100;
                    if (moneyPool > 50) {
                        change = Arrays.copyOf(change, change.length + 1);
                        change[change.length - 1] = Denominations.valueOf("50");
                        moneyPool = moneyPool - 50;
                        if (moneyPool > 20) {
                            change = Arrays.copyOf(change, change.length + 1);
                            change[change.length - 1] = Denominations.valueOf("20");
                            moneyPool = moneyPool - 20;
                            if (moneyPool > 10) {
                                change = Arrays.copyOf(change, change.length + 1);
                                change[change.length - 1] = Denominations.valueOf("10");
                                moneyPool = moneyPool - 10;
                                if (moneyPool > 5) {
                                    change = Arrays.copyOf(change, change.length + 1);
                                    change[change.length - 1] = Denominations.valueOf("5");
                                    moneyPool = moneyPool - 5;
                                    if (moneyPool > 2) {
                                        change = Arrays.copyOf(change, change.length + 1);
                                        change[change.length - 1] = Denominations.valueOf("2");
                                        moneyPool = moneyPool - 2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            endSession();
        }
        return change;
    }

  /*  public void giveChange(Denominations change) {
        switch (change) {
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
                moneyPool = moneyPool - change.getValue();
                break;
            default:
        }
    }

*/
}
