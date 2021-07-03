package se.lexicon;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineImplTest {

    VendingMachineImpl newVendingMachineImpl = new VendingMachineImpl();

    @After
    public void after(){
       newVendingMachineImpl = new VendingMachineImpl();
       ProductSequencer.resetSequencer();
    }

    @Test
    public void addCurrency() {
        //Arrange
        Denominations expBalance = Denominations.SEK100;
        int actualBalance = 0;

        //Act
        newVendingMachineImpl.addCurrency(Denominations.SEK100);
        actualBalance = newVendingMachineImpl.getBalance();

        //Assert
        assertEquals(expBalance.getValue(), actualBalance);
    }

    @Test
    public void requestFindId() {
        //Arrange
        Candy newCandy;

        //Act
        newCandy = newVendingMachineImpl.createNewCandy("testCandy", "Test Description", 15, 30);
        int actualId = newCandy.getPRODUCTNUMBER();

        //Assert
        assertNotEquals(0, actualId);

    }

    @Test
    public void requestBuy() {
        //Arrange
        Drinks coke = newVendingMachineImpl.createNewDrinks("Coke", "Drink", 30, "330");
        int expectedBalance;
        int cokeNumber = coke.getPRODUCTNUMBER();

        //Act
        newVendingMachineImpl.addCurrency(Denominations.SEK50);
        expectedBalance = newVendingMachineImpl.getBalance();
        newVendingMachineImpl.request(cokeNumber);

        //Assert
        assertNotEquals(expectedBalance, newVendingMachineImpl.getBalance());
    }

    @Test
    public void requestBuyNotEnoughMoney() {
        //Arrange
        Drinks coke = new Drinks("Coke", "Drink", 30, "330");
        int expectedBalance = newVendingMachineImpl.getBalance();

        //Act
        newVendingMachineImpl.addCurrency(Denominations.SEK20);
        int cokePrice = coke.getPrice();

        //Assert
        assertNotEquals(expectedBalance, cokePrice);
    }

    @Test
    public void endSession() {
        //Arrange

        //Act
        newVendingMachineImpl.addCurrency(Denominations.SEK100);
        newVendingMachineImpl.endSession();

        //Assert
        assertEquals(0, newVendingMachineImpl.getBalance());
    }

    @Test
    public void getDescription() {
        //Arrange
        String productsDescription = null;
        Drinks coke = new Drinks("Coke", "Drink", 30, "330");
        newVendingMachineImpl.products = new Product[] {coke};

        //Act
        productsDescription = newVendingMachineImpl.getDescription(coke.getPRODUCTNUMBER());

        //Assert
        assertNotEquals(null, productsDescription);
    }

    @Test
    public void getBalance() {
        //Arrange

        //Act
        newVendingMachineImpl.addCurrency(Denominations.SEK50);

        //Assert
        assertEquals(Denominations.SEK50.getValue(), newVendingMachineImpl.getBalance());
    }

    @Test
    public void getProducts() {
        //Arrange
        String[] allProducts;

        //Act
        newVendingMachineImpl.createNewDrinks("Coke", "Drink", 15, "330");
        allProducts = newVendingMachineImpl.getProducts();

        //Assert
        assertEquals(1, allProducts.length);

    }

    @Test
    public void createNewDrinks_Successfully() {
        //Arrange
        Drinks newDrinks = new Drinks("Coke", "Drink", 15, "330");

        //Act
        newVendingMachineImpl.createNewDrinks("Coke", "Drink", 15, "330");

        //Assert
        assertTrue(newDrinks.getPRODUCTNUMBER() != 0);
        assertEquals("Coke", newDrinks.getName());
        assertEquals("Drink", newDrinks.getDescription());
        assertNotEquals(0, newDrinks.getPrice());
        assertEquals("330", newDrinks.getVolume());
        assertTrue(newVendingMachineImpl.products.length != 0);

    }

    @Test
    public void createNewSnack_Successfully() {
        //Arrange
        Snacks newSnacks = new Snacks("Lays", "Potato Chips", 15, 120);

        //Act
        newVendingMachineImpl.createNewSnack("Lays", "Potato Chips", 15, 120);

        //Assert
        assertTrue(newSnacks.getPRODUCTNUMBER() != 0);
        assertEquals("Lays", newSnacks.getName());
        assertEquals("Potato Chips", newSnacks.getDescription());
        assertNotEquals(0, newSnacks.getPrice());
        assertEquals(120, newSnacks.getCalories());
        assertTrue(newVendingMachineImpl.products.length != 0);
    }

    @Test
    public void createNewCandy_Successfully() {
        //Arrange
        Candy newCandy = new Candy("Snickers", "Chocolate bar", 15, 55);

        //Act
        newVendingMachineImpl.createNewCandy("Snickers", "Chocolate bar", 15, 55);

        //Assert
        assertTrue(newCandy.getPRODUCTNUMBER() != 0);
        assertEquals("Snickers", newCandy.getName());
        assertEquals("Chocolate bar", newCandy.getDescription());
        assertNotEquals(0, newCandy.getPrice());
        assertEquals(55, newCandy.getSugarPercent());
        assertTrue(newVendingMachineImpl.products.length != 0);
    }
}