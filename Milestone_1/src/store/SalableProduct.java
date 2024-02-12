package store;
//Maiza Falcon Rojas
//CST-239
//02/03/2024
//This is my own work.

/**
 * Represents a salable product with properties such as name, description, price, and quantity.
 */
public class SalableProduct {
    private String name;
    private String description;
    private double price;
    private int quantity;
    
    
    /**
     * Default constructor for SalableProduct.
     */
    public SalableProduct() {
    }

    /**
     * Constructor with parameters for initializing SalableProduct.
     *
     * @param name        The name of the product.
     * @param description The description of the product.
     * @param price       The price of the product.
     * @param quantity    The initial quantity of the product.
     */
    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getter and setter methods for name, description, price, and quantity

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}