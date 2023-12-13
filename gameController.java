/*
 * Manages the game's overall flow and interactions between different components
 */
import java.util.Hashtable;
import java.util.Scanner;

public class gameController{
    /*
     * attributes
     */
    public int day;
    public static int days = 7;
    // public double dailyGoal = Math.pow(day, 2);
    // public double dailyIncome;

    static gameController gameController = new gameController();

    /**
     * @param store
     * @param menu
     * @param inventory
     * @param in
     */
    public void helpPage(Store store, Menu menu, Inventory inventory, Scanner in){
        System.out.println("What aspect of the store would you like to know about?" 
                + "\n a. Basic Infomation" 
                + "\n b. Menu"
                + "\n c. Inventory"
                + "\n d. Game Process");
        handleInput.handleHelpPageInput(store, menu, inventory, gameController, in, true);
    }

    /**
     * @return
     */
    public String description(){
        String description = ("- Your business will be run on a day to day basis, during the day you will make orders to earn money, and at the end of the day you will have the opportunity to review your bills, extend your opning hours, and restock inventory!" 
        + "\n - openingTime represents the total opening hour of your store. You will earn more money with longer opening time per day. The maximum value is 10 hours and each extra hour costs 50.00." + "\n - The goal of your game is to imrpove your store to acheive daily goal for 7 days!");
        // System.out.println("equipment represents the equipments in your store. Better equipments brings higher income, and you can improve equipment by money. The maximum value is 10 points and each extra point costs 300.00.");
        // System.out.println("- technique represents your technique of making orders. Better technique enhance income as well as satisfaction from customers. The maximum value is 10 points and you can improve technique by reaching goals in income.");
        // System.out.println("- cleaniness represents the environment of your store. The more dirty your store is, the less customers you will take. The maximum value is 10 points and you need to close your store to take a deep clean.");
        // System.out.println("- satisfaction represents the feedback from customers. You can gain more tips with better satisfaction. The maximum value is 5.0 and it consists of all factors of your store.");
        return description;
    }

    public double dailyOrder(Store store, Menu menu, Inventory inventory, Hashtable<Integer, String> dailyReceipt) {
        double dailyIncome = 0;
        for (int time = 1; time <= store.openingTime; time++) {
            MenuItem order = menu.getRandomMenuItem();
            String name = order.name;
            double price = order.price;
    
            if (orderAvailability(inventory, order)) {
                dailyIncome += price;
                updateInventory(inventory, order);
                dailyReceipt.put(time, name + "\t " + price);
            } else {
                dailyReceipt.put(time, "Insufficient inventory" + "\t " + "0.0");
            }
        }
        return dailyIncome;
    }
    
    private boolean orderAvailability(Inventory inventory, MenuItem order) {
        return inventory.cup >= 1 && inventory.milk >= order.milk && inventory.tea >= order.tea && (!order.boba || inventory.boba >= 1);
    }
    
    private void updateInventory(Inventory inventory, MenuItem order) {
        inventory.cup -= 1;
        inventory.milk -= order.milk;
        inventory.tea -= order.tea;
        if (order.boba) {
            inventory.boba -= 1;
        }
    }    

    public String getReceipt(Integer day, Hashtable<Integer, String> dailyReceipt, double dailyIncome){
        StringBuilder receipt = new StringBuilder();
        receipt.append("\nCheck your receipt: \n");
        receipt.append("Day " + day);
        receipt.append("\n----------------\n");
        for (Integer key : dailyReceipt.keySet()) {
            receipt.append("Order ").append(key).append(": ").append(dailyReceipt.get(key)).append("\n");
        }
        receipt.append("----------------\n");
        receipt.append("Total income: ").append(dailyIncome).append("\n");
        return receipt.toString();        
    }

    public void manageTab(Inventory inventory, Menu menu, Store store, double dailyIncome, Scanner in){
        store.balance += dailyIncome;
        boolean loop = true;
        System.out.println("You worked very hard today! How do you want to manage your store?" 
            + "\n a. Check inventory and restock" 
            + "\n b. Extend opening hour"
            + "\n c. Exit management tab");
        while (loop) {
            loop = handleInput.handleManageInput(store, menu, inventory, gameController, in, loop);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * Initialization
         */
        Store bobaStore = new Store("Boba Fever");
        Inventory inventory = new Inventory();
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Small Milk Tea", 1, 1, false, false, 4.00));
        menu.addMenuItem(new MenuItem("Large Milk Tea",2, 1, true, false, 6.00));
        menu.addMenuItem(new MenuItem("Small Boba Milk Tea",1, 1, false, true, 5.00));
        menu.addMenuItem(new MenuItem("Large Boba Milk Tea",2, 1, true, true, 7.50));
        menu.addMenuItem(new MenuItem("Small Milk with Boba",0, 2, false, true, 5.00));
        menu.addMenuItem(new MenuItem("Large Milk with Boba",0, 3, true, true, 7.50));
        handleInput handle = new handleInput();
        Scanner in = new Scanner (System.in);

        /*
         * Welcome
         */
        System.out.println("\nWelcome to Boba Fever! Get ready to fulfill customer orders and keep your business running to survive for a week!");
        System.out.print("The initial store is named " + bobaStore.name + ". ");
        handle.handleResetNameInput(bobaStore, in);

        /*
         * Print store information and rules, begin
         */
        System.out.println("\nNow, let's explore your store.");
        gameController.helpPage(bobaStore, menu, inventory, in);
        System.out.println("\nIt appears you have some understanding of your store. Are you ready to start?");
        Boolean loop = handleInput.handleYesNoInput(in);

        /*
         * 
         */
        if (!loop) {
            System.out.println("\nThat's perfectly fine. Hope to see you back soon! ");
        }
        else if (loop) {
            System.out.println("\nLet's get started!\n");
            for (int day = 1; day <= days; day++) {
                double dailyGoal = Math.pow(day, 2);
                Hashtable<Integer, String> dailyReceipt = new Hashtable<>();
                System.out.println("Goal of day " + day + ": " + dailyGoal);

                double dailyIncome = gameController.dailyOrder(bobaStore, menu, inventory, dailyReceipt);
                String Receipt = gameController.getReceipt(day, dailyReceipt, dailyIncome);
                System.out.println(Receipt);

                if (dailyIncome < dailyGoal) {
                    System.out.println("Today's goal was not achieved. Game Over!");
                    break; 
                } else {
                    System.out.println("Congratulations! You achieved today's goal! Let's switch to the management tab...\n");
                    gameController.manageTab(inventory, menu, bobaStore, dailyIncome, in);
                }
            }
        }
    in.close();
    }
}