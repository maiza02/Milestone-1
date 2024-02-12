package store;
//Maiza Falcon Rojas
//CST-239
//02/03/2024
//This is my own work.

import java.util.HashMap;
import java.util.Map;


/**
 * Represents a shopping cart where items can be added, removed, and the total cost can be calculated.
 */
public class ShoppingCart {
    private Map<SalableProduct, Integer> cartItems;

    public ShoppingCart() {
        cartItems = new HashMap<>();
    }

    
    /**
     * Adds a specified quantity of a product to the shopping cart.
     *
     * @param product  The product to add to the cart.
     * @param quantity The quantity of the product to add.
     */
    public void addItem(SalableProduct product, int quantity) {
        // Add item to cart logic
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    
    /**
     * Removes a product from the shopping cart.
     *
     * @param product The product to remove from the cart.
     */
    public void removeItem(SalableProduct product) {
        // Remove item from cart logic
        cartItems.remove(product);
    }

    
    /**
     * Displays the items in the shopping cart.
     */
    public void displayCart() {
        // Display items in the cart
        for (Map.Entry<SalableProduct, Integer> entry : cartItems.entrySet()) {
            SalableProduct product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Item: " + product.getName() + ", Quantity: " + quantity);
        }
    }

    
    /**
     * Calculates the total cost of items in the shopping cart.
     *
     * @return The total cost of items in the cart.
     */
    public double calculateTotal() {
        // Calculate total cost logic
        double total = 0.0;
        for (Map.Entry<SalableProduct, Integer> entry : cartItems.entrySet()) {
            SalableProduct product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }

    
    /**
     * Returns the total number of items in the shopping cart.
     *
     * @return The total number of items in the cart.
     */
    public int getItemCount() {
        // Get the total number of items in the cart
        int count = 0;
        for (int quantity : cartItems.values()) {
            count += quantity;
        }
        return count;
    }

    
    /**
     * Displays the items in the shopping cart and prompts the user for further actions.
     */
    public void checkout() {
        System.out.println("Items in your shopping cart are:");
        for (Map.Entry<SalableProduct, Integer> entry : cartItems.entrySet()) {
            SalableProduct product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Item: " + product.getName() + ", Quantity: " + quantity);
        }

        double total = calculateTotal();
        System.out.println("Total: $" + total);

        System.out.println("Are you ready to checkout? (yes/no)");
       
    }
}
