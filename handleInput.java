/*
 * 
 */
import java.util.Scanner;

public class handleInput {

    /**
     * method that deal with name change of the store
     * @param store
     * @param in
     */
    public void handleResetNameInput(Store store, Scanner in) {
        while (true) {
            System.out.println("Would you like to make a change? (yes/no): ");
            String input = in.nextLine().trim().toLowerCase();
    
            if (input.equals("yes")) {
                System.out.println("Continuing...");
                store.setName(in);
                break;
            } else if (input.equals("no")) {
                System.out.println("Continuing as Boba Store...");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    /**
     * method that deal with help page at the beginning of the game
     * @param store
     * @param menu
     * @param inventory
     * @param in
     * @param loop
     */
    public static void handleHelpPageInput(Store store, Menu menu, Inventory inventory, Scanner in, Boolean loop) {
        String storeInfo = store.getStoreInfo();
        String menuList = menu.getMenuList();
        String inventoryList = inventory.getInventoryList();
        String description = gameController.description();

        while (loop){
        System.out.println("(a/b/c/d): ");
        String input = in.next().trim().toLowerCase();
            if (input.equals("a")) {
                System.out.println("Loading...");
                System.out.println(storeInfo);
            } else if (input.equals("b")) {
                System.out.println("Loading...");
                System.out.println(menuList);
            } else if (input.equals("c")) {
                System.out.println("Loading...");
                System.out.println(inventoryList);
            } else if (input.equals("d")) {
                System.out.println("Loading...");
                System.out.println(description);
            } else {
                System.out.println("Invalid input. Please enter 'a', 'b', 'c' or 'd'.");
            }
        System.out.println("\nDo you have any other parts you'd like to know about?");
        loop = handleInput.handleYesNoInput(in);
        }
    }

    /**
     * method that handle manage tab process
     * @param store
     * @param menu
     * @param inventory
     * @param in
     * @param loop
     * @return
     */
    public static boolean handleManageInput(Store store, Menu menu, Inventory inventory, Scanner in, Boolean loop){
        while (loop){
        System.out.println("\n a. Check inventory and restock" 
        + "\n b. Extend opening hour"
        + "\n c. Exit management tab" + "\n(a/b/c): ");
        String input = in.next().trim().toLowerCase();
            if (input.equals("a")) {
                System.out.println("Loading...");
                handleRestockInput(store, inventory, in);
            } else if (input.equals("b")) {
                System.out.println("Loading...");
                store.extendOpeningTime(store, in);
            } else if (input.equals("c")) {
                System.out.println("\nMoving on to the next day...\n");
                return false; 
            } else {
                System.out.println("Invalid input. Please enter 'a' or 'b'.");
            }
        }
        System.out.println("\nDo you have any other tasks to complete in the management tab?");
        return handleInput.handleYesNoInput(in);
    }

    /**
     * method that deal with restock - part 1
     * @param store
     * @param menu
     * @param inventory
     * @param in
     * @param loop
     */
    public static void handleRestockInput(Store store, Inventory inventory, Scanner in) {
        while (true) {
            String inventoryList = inventory.getInventoryList();
            System.out.println(inventoryList);

            System.out.println("Enter the index that you want to purchase (a/b/c/d), or 'e' to exit: ");
            String input = in.next().trim().toLowerCase();

            if ("e".equals(input)) {
                break; // Exit the restock loop
            }

            if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d")) {
                int number = handleRestockNumberInput("Enter the number of items you want to purchase: ", in);
                double cost = inventory.restockCost(input, number);

                if (store.getBalance() >= cost) {
                    inventory.restock(store, input, number, in);
                    System.out.println("Restock successful. New balance: " + store.getBalance());
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    /**
     * method that deal with restock - part 2
     * @param store
     * @param inventory
     * @param input
     * @param in
     */
    private static int handleRestockNumberInput(String message, Scanner in) {
        System.out.println(message);
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            in.next(); // Consume the invalid input
        }
        return in.nextInt();
    }

    /**
     * method that deal with request for extending opening hour
     * @param store
     * @param in
     */
    public static void handleExtendHourInput(Store store, Scanner in){
        if (in.hasNextInt()) {
            int input = in.nextInt();
            int openingTime = store.getOpeningTime();
            double balance = store.getBalance();
            if (openingTime == 10 || openingTime + input > 10) {
                System.out.println("Invalid number. Back to main tab...");
            } else if (openingTime + input <= 10) {
            System.out.println("Extend " + input + " of opening hour will cost you " + input * 20 + ". Purchase confirmed?");
            boolean response = handleYesNoInput(in);
            if (response) {
                if (balance >= input * 20) {
                store.setOpeningTime(store.getOpeningTime()  + input);
                store.setBalance(store.getBalance() - input * 20);
                System.out.println("Purchase Successful. You spend " + input * 20 + " to extend your store's opening time! You can take " + openingTime + " orders per day and your balance is " + store.getBalance() + " .");
                } else {
                System.out.println("Insufficient balance, please try again.");
                }
            } else {
                System.out.println("Returning to the previous step...");
            }
            } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            in.next(); 
            }
        }
    }
    
    /**
     * method that deal with general yes/no response questions
     * @param in
     * @return
     */
    public static boolean handleYesNoInput(Scanner in) {
        while (true) {
            System.out.println(" (yes/no): ");
            String input = in.next().trim().toLowerCase();
    
            if (input.equals("yes")) {
                System.out.println("Continuing...");
                return true;
            } else if (input.equals("no")) {
                System.out.println("Continuing...");
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}