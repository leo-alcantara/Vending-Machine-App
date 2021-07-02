package se.lexicon;

import org.junit.Test;

import static org.junit.Assert.*;

public class DrinksTest {

    @Test
    public void examine() {
        //Arrange
        Drinks coke = new Drinks("Coke", "Drink", 30, "330");
        String description;
        //Act
        description = coke.examine();

        //Assert
        assertNotEquals(null, description);
    }

    @Test
    public void use() {
        //Arrange
        Drinks coke = new Drinks("Coke", "Drink", 30, "330");
        String use;

        //Act
        use = coke.use();

        //Assert
        assertNotEquals(null, use);
    }

    @Test
    public void getVolume() {
        //Arrange
        Drinks coke = new Drinks("Coke", "Drink", 30, "330");
        String volume;

        //Act
        volume = coke.getVolume();

        //Assert
        assertNotEquals(null, volume);

    }
}