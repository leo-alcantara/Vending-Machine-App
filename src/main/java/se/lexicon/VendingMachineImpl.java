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

    //Methods
    @Override
    public void addCurrency(int money){
        moneyPool = moneyPool + money;
    }

    @Override
    public Product request(int productNumber){
    }

    @Override
    public int endSession(){
        System.out.println("Your change is " + moneyPool + ". Thank you for buying our products.");
        moneyPool = 0;
        return moneyPool;
    }

    @Override
    public String getDescription(int productNumber){
        for (int i = 0; i < products.length; i++) {
            if(products[i].equals(productNumber)){

            }

        }

    }

    @Override
    public int getBalance(){
        return moneyPool;
    }

    public Product buy(int money, int prodNum){
        if(money >= moneyPool){
           moneyPool = moneyPool - money;
        }
         return newDrink;
    }


    @Override
    public String[] getProducts(){
         newDrink.getName();
         return products;

    }





}
