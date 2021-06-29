package se.lexicon;

public abstract class Product {

    //Fields
    String name;
    String description;
    int price;
    private final int PRODUCTNUMBER;

    //Constructor
    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.PRODUCTNUMBER = ProductSequencer.nextProductNumber();
    }

    //Methods
    abstract String examine();

    abstract String use();

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPRODUCTNUMBER() {
        return PRODUCTNUMBER;
    }
}
