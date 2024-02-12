package store;
//Maiza Falcon Rojas
//CST-239
//02/03/2024
//This is my own work.


import java.util.HashMap;
import java.util.Map;

/**
 * Represents the storefront of a shop with inventory management and purchase/cancellation functionalities.
 */
public class StoreFront {
    private Map<String, SalableProduct> storeInventory;

    public StoreFront() {
        storeInventory = new HashMap<>();
    }

    /**
     * Initializes the store with sample products.
     */
    public void initializeStore() {
        // Initialization logic (adding products to storeInventory)
        SalableProduct sampleProduct = new SalableProduct();
        sampleProduct.setName("SampleProduct");
        sampleProduct.setDescription("A sample product");
        sampleProduct.setPrice(10.0);
        sampleProduct.setQuantity(20);

        storeInventory.put(sampleProduct.getName(), sampleProduct);
    }

    
    /**
     * Handles the purchase of a product and updates the inventory and shopping cart.
     *
     * @param productName     The name of the product to be purchased.
     * @param quantity        The quantity of the product to be purchased.
     * @param shoppingCart    The shopping cart where the purchased items are added.
     * @param inventoryManager The inventory manager for checking and updating product availability.
     */
    public void purchaseProduct(String productName, int quantity, ShoppingCart shoppingCart, InventoryManager inventoryManager) {
        SalableProduct product = storeInventory.get(productName);
        if (product != null) {
            if (inventoryManager.checkAvailability(product, quantity)) {
                // Update inventory and complete purchase
                inventoryManager.updateQuantity(product, -quantity);
                shoppingCart.addItem(product, quantity);

                System.out.println("Purchase successful: " + quantity + " " + productName + "(s)");
            } else {
                System.out.println("Not enough quantity available for purchase.");
            }
        } else {
            System.out.println("Product not found in inventory.");
        }
    }
    
    
    /**
     * Cancels a previous purchase and returns the items to the inventory and removes them from the cart.
     *
     * @param productName     The name of the product to be canceled.
     * @param quantity        The quantity of the product to be canceled.
     * @param shoppingCart    The shopping cart from which the items will be removed.
     * @param inventoryManager The inventory manager for updating product quantities.
     */
    public void cancelPurchase(String productName, int quantity, ShoppingCart shoppingCart, InventoryManager inventoryManager) {
        // Cancellation logic
        SalableProduct product = storeInventory.get(productName);
        if (product != null) {
            inventoryManager.updateQuantity(product, quantity);
            shoppingCart.removeItem(product);
            System.out.println("Purchase canceled: " + quantity + " " + productName + "(s) returned to inventory.");
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    
    /**
     * Retrieves the product list from the store inventory.
     *
     * @return The map containing product names and corresponding SalableProduct objects.
     */
    public Map<String, SalableProduct> getProductList() {
        return storeInventory;
    }
}
