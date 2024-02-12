package store;
//Maiza Falcon Rojas
//CST-239
//02/03/2024
//This is my own work.


/**
 * Main application class for simulating a storefront and shopping experience.
 */
public class StoreFrontApplication {

	 /**
     * Main method for running the storefront application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Instantiate and initialize objects
        StoreFront storeFront = new StoreFront();
        InventoryManager inventoryManager = new InventoryManager();
        ShoppingCart shoppingCart = new ShoppingCart();

        storeFront.initializeStore();
        SalableProduct sampleProduct = storeFront.getProductList().get("SampleProduct");

        // Ensure sampleProduct is not null before using it
        if (sampleProduct != null) {
            // Purchase flow
            storeFront.purchaseProduct(sampleProduct.getName(), 2, shoppingCart, inventoryManager);
            shoppingCart.checkout();

            // Cancellation flow
            storeFront.cancelPurchase(sampleProduct.getName(), 2, shoppingCart, inventoryManager);
        } else {
            System.out.println("Sample product not found in inventory.");
        }
    }
}