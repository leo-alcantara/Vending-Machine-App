package se.lexicon;

public class VendingMachineImpl implements VendingMachine {

    int[] denominations;
    Product[] products;
    int moneyPool;

    public VendingMachineImpl(int[] denominations, Product[] products, int moneyPool) {
        this.denominations = denominations;
        this.products = products;
        this.moneyPool = moneyPool;
    }

    Drinks newDrink;

    @Override
    public boolean addMoney(int money){
       moneyPool = moneyPool + money;
       return true;
    }

    @Override
    public Product buy(int money, int prodNum){
        if(money >= moneyPool){
           moneyPool = moneyPool - money;
        }

         return newDrink;
    }

    @Override
    public int returnChange(){
      return moneyPool;
    }

    @Override
    public void presentProducts(){
         newDrink.getName();

    }

    @Override
    public int getBalance(){
       return moneyPool;
    }



}
