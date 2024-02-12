package store;
//Maiza Falcon Rojas
//CST-239
//02/03/2024
//This is my own work.


/**
 * Manages the inventory of salable products, providing methods for checking availability and updating quantities.
 */
public class InventoryManager {
   
	
	/**
     * Checks if the specified quantity of a product is available in the inventory.
     *
     * @param product  The product to check availability for.
     * @param quantity The quantity to check for availability.
     * @return True if the quantity is available, false otherwise.
     */
	public boolean checkAvailability(SalableProduct product, int quantity) {
        return product.getQuantity() >= quantity;
    }

	
	/**
     * Updates the quantity of a product in the inventory.
     *
     * @param product  The product whose quantity is to be updated.
     * @param quantity The quantity to add (positive) or subtract (negative).
     */
    public void updateQuantity(SalableProduct product, int quantity) {
        product.setQuantity(product.getQuantity() + quantity);
    }
}