package se.lexicon;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnacksTest {

    @Test
    public void examine() {
        //Arrange
        Snacks chips = new Snacks("Lays", "Chips", 30, 120);
        String description;
        //Act
        description = chips.examine();

        //Assert
        assertNotEquals(null, description);

    }

    @Test
    public void use() {
        //Arrange
        Snacks chips = new Snacks("Lays", "Chips", 30, 120);
        String use;
        //Act
        use = chips.examine();

        //Assert
        assertNotEquals(null, use);

    }
}