package store;
//Maiza Falcon Rojas
//CST-239
//02/03/2024
//This is my own work.


import java.util.Scanner;


/**
 * Simulates a shopping application where the user can interact with the store, view products,
 * add items to the cart, and proceed to checkout.
 */
public class ShoppingCartApp {
    public static void main(String[] args) {
        System.out.println("Welcome to my shop!");
        System.out.println("Would you like to shop? (Yes/No)");

        Scanner scanner = new Scanner(System.in);
        String startShopping = scanner.nextLine().toLowerCase();

        if ("yes".equals(startShopping)) {
            System.out.println("Do you want to look at our products? (yes/no)");

            String viewProducts = scanner.nextLine().toLowerCase();

            if ("yes".equals(viewProducts)) {
                SalableProduct sampleProduct = new SalableProduct("SampleProduct", "A sample product", 10.0, 20);
                displayProducts();
                System.out.println("Would you like to enter any of the items into your shopping cart? (yes/no)");

                String addToCart = scanner.nextLine().toLowerCase();

                if ("yes".equals(addToCart)) {
                    ShoppingCart shoppingCart = new ShoppingCart();
                    addItemToCart(scanner, shoppingCart, sampleProduct);

                    System.out.println("Items in your shopping cart are:");
                    shoppingCart.displayCart();
                    System.out.println("Total: $" + shoppingCart.calculateTotal());

                    System.out.println("Are you ready to checkout? (yes/no)");

                    String checkout = scanner.nextLine().toLowerCase();

                    if ("yes".equals(checkout)) {
                        System.out.println("Your total is: $" + shoppingCart.calculateTotal());
                        System.out.println("Thank you for shopping!");
                    } else {
                        System.out.println("Okay, let me know when you're ready or if you want to cancel an item. (ready now/cancel item)");

                        String nextAction = scanner.nextLine().toLowerCase();

                        if ("ready now".equals(nextAction)) {
                            System.out.println("Your total is: $" + shoppingCart.calculateTotal());
                            System.out.println("Thank you for shopping!");
                        } else if ("cancel item".equals(nextAction)) {
                            cancelItem(scanner, shoppingCart, sampleProduct);
                        }
                    }
                } else {
                    System.out.println("Okay, bye! Come again.");
                }
            } else {
                System.out.println("Okay, bye! Come again.");
            }
        } else {
            System.out.println("Okay, bye! Come again.");
        }

        scanner.close();
    }

    private static void displayProducts() {
        System.out.println("List of products:");
        System.out.println("1. Pack of stickers - Price: $5.00");
        System.out.println("2. Metal pin - Price: $10.00");
        System.out.println("3. Keychain - Price: $7.00");
    }

    
    /**
     * Displays the list of available products and prompts the user to add items to the shopping cart.
     *
     * @param scanner       The Scanner object for user input.
     * @param shoppingCart  The shopping cart where items will be added.
     * @param sampleProduct The sample product to be added to the cart.
     */
    private static void addItemToCart(Scanner scanner, ShoppingCart shoppingCart, SalableProduct sampleProduct) {
        int limit = 5;
        while (true) {
            if (shoppingCart.getItemCount() >= limit) {
                System.out.println("Sorry, items out of stock.");
                break;
            }

            System.out.println("Which item do you want to add to your cart? (Enter item number)");

            // Assuming you have items with numbers 1, 2, and 3 in your inventory
            int itemNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            SalableProduct selectedProduct = null;

            // Retrieve the selected product based on the itemNumber
            switch (itemNumber) {
                case 1:
                    selectedProduct = new SalableProduct("Stickers", "Pack of stickers", 5.0, 100);
                    break;
                case 2:
                    selectedProduct = new SalableProduct("MetalPin", "Metal pin", 10.0, 50);
                    break;
                case 3:
                    selectedProduct = new SalableProduct("Keychain", "Keychain", 7.0, 75);
                    break;
                default:
                    System.out.println("Invalid item number. Please select a valid item.");
                    continue;
            }

            System.out.println("How many do you want?");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // Add the selected product to the cart
            shoppingCart.addItem(selectedProduct, quantity);

            System.out.println("Do you want to add more items to your cart? (yes/no)");
            String addMore = scanner.nextLine().toLowerCase();

            if ("no".equals(addMore)) {
                break;
            }
        }
    }

    
    /**
     * Cancels a selected item from the shopping cart and displays the updated cart with the new total.
     *
     * @param scanner       The Scanner object for user input.
     * @param shoppingCart  The shopping cart from which the item will be canceled.
     * @param sampleProduct The sample product to be canceled from the cart.
     */
    private static void cancelItem(Scanner scanner, ShoppingCart shoppingCart, SalableProduct sampleProduct) {
        System.out.println("Which item do you want to cancel? (Enter item number)");
        int itemNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        shoppingCart.removeItem(sampleProduct);

        System.out.println("Okay, item canceled.");
        System.out.println("Updated cart with new total:");
        shoppingCart.displayCart();
        System.out.println("Total: $" + shoppingCart.calculateTotal());
    }
}