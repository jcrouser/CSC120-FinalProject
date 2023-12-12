/*
 * Tracks the restaurant's inventory of ingredients and supplies
 */

import java.util.Scanner;

public class Inventory {
    /*
     * attributes
     */
    public int cup;
    public int tea;
    public int milk;
    public int boba;
    public double cupBuyIn;
    public double teaBuyIn;
    public double milkBuyIn;
    public double bobaBuyIn;

    /*
     * constructor that create inventory with default value
     */
    public Inventory(){
        this.cup = 5;
        this.tea = 5;
        this.milk = 5;
        this.boba = 5;
        this.cupBuyIn = 1;
        this.teaBuyIn = 1;
        this.milkBuyIn = 1;
        this.bobaBuyIn = 1;
    }

    /*
     * accessor of inventory
     */
    public String getInventoryList() {
        String inventoryList = "Current Inventory:\n" +"----------------\n"
                                    + "a. Cups: " + cup + "\tBuy in price: " + cupBuyIn 
                                    + "\nb. Tea: " + tea + "\tBuy in price: " + teaBuyIn 
                                    + "\nc. Milk: " + milk  + "\tBuy in price: " + milkBuyIn 
                                    + "\nd. Boba: " + boba + "\tBuy in price: " + bobaBuyIn 
                                    + "\n----------------";
        return inventoryList;
    }

    /*
     * method to restock
     * @param   name    category of inventory
     * @param   number  number for restock
     * @return  stockList   updated stockList
     */
    public void restock(Store store, Scanner in){
        String inventoryList = getInventoryList();
        System.out.println(inventoryList);

        System.out.println("Enter the index that you want to purchase (a/b/c/d): ");
        String name = in.next();

        int number;
        double price;
        double totalPrice;

        switch (name.toLowerCase()) {
            case "a": // Cups
                System.out.println("Enter the number of cups to purchase: ");
                number = in.nextInt();
                price = cupBuyIn;
                break;
            case "b": // Tea
                System.out.println("Enter the number of tea units to purchase: ");
                number = in.nextInt();
                price = teaBuyIn;
                break;
            case "c": // Milk
                System.out.println("Enter the number of milk units to purchase: ");
                number = in.nextInt();
                price = milkBuyIn;
                break;
            case "d": // Boba
                System.out.println("Enter the number of boba units to purchase: ");
                number = in.nextInt();
                price = bobaBuyIn;
                break;
            default:
                System.out.println("Invalid index.");
                return; // Exit the method if invalid input
            }
            
        totalPrice = price * number;
        System.out.println("Buying in " + number + " units will cost you " + totalPrice);
        System.out.println("Purchase confirmed? (yes/no)");
        String response = in.next();

        if ("yes".equalsIgnoreCase(response)) {
            if (store.balance >= totalPrice) {
                switch (name.toLowerCase()) {
                case "a":
                    cup += number;
                    store.balance -= totalPrice;
                    break;
                case "b":
                    tea += number;
                    store.balance -= totalPrice;
                    break;
                case "c":
                    milk += number;
                    store.balance -= totalPrice;
                    break;
                case "d":
                    boba += number;
                    store.balance -= totalPrice;
                    break;
                }
                System.out.println("Purchase successful!");
                String newInventoryList = getInventoryList();
                System.out.println(newInventoryList + "\nBalance: " + store.balance);
            } else {
                System.out.println("Insufficient balance. Purchase canceled.");
            }
        } else {
            System.out.println("Purchase canceled.");
        }
    }
}
