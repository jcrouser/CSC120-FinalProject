/*
 * 
 */
import java.util.Scanner;

public class handleInput {
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

    public static void handleHelpPageInput(Store store, Menu menu, Inventory inventory, gameController gameController, Scanner in, Boolean loop) {
        String storeInfo = store.getstoreInfo();
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

    public static boolean handleManageInput(Store store, Menu menu, Inventory inventory, gameController gameController, Scanner in, Boolean loop){
        while (loop){
        System.out.println("(a/b/c): ");
        String input = in.next().trim().toLowerCase();
            if (input.equals("a")) {
                System.out.println("Loading...");
                handleRestockInput(store, menu, inventory, gameController, in, true);
            } else if (input.equals("b")) {
                System.out.println("Loading...");
                store.extendOpeningTime(store, in);
            } else if (input.equals("c")) {
                System.out.println("Moving on to the next day...\n");
                return false; 
            } else {
                System.out.println("Invalid input. Please enter 'a' or 'b'.");
            }
        }
        System.out.println("\nDo you have any other tasks to complete in the management tab?");
        return handleInput.handleYesNoInput(in);
    }

    public static void handleRestockInput(Store store, Menu menu, Inventory inventory, gameController gameController, Scanner in, Boolean loop){
        while (loop){
        String inventoryList = inventory.getInventoryList();
        System.out.println(inventoryList);
    
        System.out.println("Enter the index that you want to purchase (a/b/c/d): ");
        String input = in.next().trim().toLowerCase();

        if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d")) {
            handleRestockNumberInput(store, inventory, input, in);
            inventoryList = inventory.getInventoryList();
            System.out.println(inventoryList);
            System.out.println("You have " + store.balance + " left.");
        } else {
            System.out.println("Invalid input.");
        }
        System.out.println("\nDo you have other item to restock?");
        loop = handleInput.handleYesNoInput(in);
        }
    }

    public static void handleRestockNumberInput(Store store, Inventory inventory, String input, Scanner in){
        System.out.println("Loading...");
        System.out.println("Enter the number of item that you want to purchase: ");
        int number = in.nextInt();
        inventory.restock(store, input, number, in);
    }

    // public void restock(Store store, Scanner in){
        //         System.out.println("Purchase successful!");
        //         String newInventoryList = getInventoryList();
        //         System.out.println(newInventoryList + "\nBalance: " + store.balance);
        //     } else {
        //         System.out.println("Insufficient balance. Purchase canceled.");
        //     }
        // } else {
        //     System.out.println("Purchase canceled.");
        // }

    public static void handleExtendHourInput(Store store, Scanner in){
        int input = in.nextInt();
            if (store.openingTime >= 10) {
                System.out.println("Invalid number.");
            } else if (store.openingTime + input <= 10) {
            System.out.println("Extend " + input + " of opening hour will cost you 20.00. Purchase confirmed?");
            boolean response = handleYesNoInput(in);
            if (response) {
                if (store.balance >= input * 20) {
                store.openingTime += input;
                store.balance -= input * 20;
                System.out.println("Purchase Successful. You spend " + input * 20 + " to extend your store's opening time! You can take" + store.openingTime + "orders per day and your balance is " + store.balance + " .");
                } else {
                System.out.println("Insufficient balance, please try again.");
                }
            } else {
                System.out.println("Returning to the previous step...");
            }
        }
    }
    
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