package se.lexicon;

public class VendingMachineImpl implements VendingMachine {
    //Fields
    int[] denominations;
    Product[] products;
    int moneyPool;

    //Constructors
    public VendingMachineImpl(int[] denominations, Product[] products, int moneyPool) {
        this.denominations = denominations;
        this.products = products;
        this.moneyPool = moneyPool;
    }

    //Instantiations
    Drinks newDrink;
    Snacks newSnacks;
    Candy newCandy;


    //Methods
    @Override
    public void addCurrency(int money) {
        moneyPool = moneyPool + money;
    }

    @Override
    public Product request(int productNumber) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getPRODUCTNUMBER() == productNumber) {
                if (products[i].equals(newDrink)) {
                    int drinkCost = newDrink.getPrice();
                    moneyPool = moneyPool - drinkCost;
                } else if (products[i].getPRODUCTNUMBER() == productNumber) {
                    if (products[i].equals(newSnacks)) {
                        int snacksCost = newSnacks.getPrice();
                        moneyPool = moneyPool - snacksCost;
                    } else if (products[i].getPRODUCTNUMBER() == productNumber) {
                        if (products[i].equals(newCandy)) {
                            int candyCost = newCandy.getPrice();
                            moneyPool = moneyPool - candyCost;
                        }  else {
                            System.out.println("Product number not valid.");
                        }
                    }
                }
            }
        }
        return products[i];
    }

    @Override
    public int endSession() {
        System.out.println("Your change is " + moneyPool + ". Thank you for buying our products.");
        moneyPool = 0;
        return moneyPool;
    }

    @Override
    public String getDescription(int productNumber) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getPRODUCTNUMBER() == productNumber) {
                if (products[i].equals(newDrink)) {
                    newDrink.toString();
                } else if (products[i].equals(newSnacks)) {
                    newSnacks.toString();
                } else if (products[i].equals(newCandy)) {
                    newCandy.toString();
                }
            } else {
                System.out.println("Product number not valid.");
            }
        }
        return "Your product";
    }

    @Override
    public int getBalance() {
        return moneyPool;
    }

    public Product buy(int money, int prodNum) {
        if (money >= moneyPool) {
            moneyPool = moneyPool - money;
        }
        return newDrink;
    }


    @Override
    public String[] getProducts() {
        String[] allProducts = products;
        System.out.println(products.toString());
        return products;

    }


}
