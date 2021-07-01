package se.lexicon;

import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void examine() {
        //Arrange
        Candy chocolate = new Candy("Snickers", "Chocolate Bar", 15, 50);
        String description;
        //Act
        description = chocolate.examine();

        //Assert
        assertNotEquals(null, description);
    }

    @Test
    public void use() {
        //Arrange
        Candy chocolate = new Candy("Snickers", "Chocolate Bar", 15, 50);
        String use;
        //Act
        use = chocolate.examine();

        //Assert
        assertNotEquals(null, use);


    }
}