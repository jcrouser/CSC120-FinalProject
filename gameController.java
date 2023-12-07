/*
 * Manages the game's overall flow and interactions between different components
 */

import java.util.Scanner;

public class  gameController{
    public static void main(String[] args) {
        /*
         * initialization
         */
        Store bobaStore = new Store("Boba Fever");
        System.out.println("\nWelcome to the Boba Fever game! In your boba store, you can prepare orders for customers and manage your business.");
        Scanner input = new Scanner (System.in);
        System.out.print("\nThe name of the initial store is " + bobaStore.name + ". Do you want to rename it? (yes/no)");
        String response = input.next();
        if ("yes".equalsIgnoreCase(response)) {
            bobaStore.setName();
        }
        input.close();

        /*
         * print out inventory, balance, and other information of current store
         */
        System.out.println("\nNow, let's take a look at basic information of your store. Here is the initial status: ");
        bobaStore.storeInfo();

        /*
         * print out description and process of the game
         */
        System.out.println("\nAnd here is the description of how to run your store:");
        bobaStore.description();

    }
}