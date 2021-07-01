package se.lexicon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineImplTest {

    VendingMachineImpl newVendingMachineImpl = new VendingMachineImpl();

    @Test
    public void addCurrency() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void request() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void endSession() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void getDescription() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void getBalance() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void getProducts() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void createNewDrinks_Successfully() {
        //Arrange
        Drinks newDrinks = new Drinks("Coke", "Drink", 15, "330");
        //Act

        //Assert
        assertTrue(newDrinks.getPRODUCTNUMBER() != 0);
        assertEquals("Coke", newDrinks.getName());
        assertEquals("Drink", newDrinks.getDescription());
        assertNotEquals(0, newDrinks.getPrice());
        assertEquals("330", newDrinks.getVolume());
    }

    @Test
    public void createNewSnack_Successfully() {
        //Arrange
        Snacks newSnacks = new Snacks("Lays", "Potato Chips", 15, 120);

        //Act

        //Assert
        assertTrue(newSnacks.getPRODUCTNUMBER() != 0);
        assertEquals("Lays", newSnacks.getName());
        assertEquals("Potato Chips", newSnacks.getDescription());
        assertNotEquals(0, newSnacks.getPrice());
        assertEquals(120, newSnacks.getCalories());
    }

    @Test
    public void createNewCandy_Successfully() {
        //Arrange
        Candy newCandy = new Candy("Snickers", "Chocolate bar", 15, 55);


        //Act

        //Assert
        assertTrue(newCandy.getPRODUCTNUMBER() != 0);
        assertEquals("Snickers", newCandy.getName());
        assertEquals("Chocolate bar", newCandy.getDescription());
        assertNotEquals(0, newCandy.getPrice());
        assertEquals(55, newCandy.getSugarPercent());
    }
}