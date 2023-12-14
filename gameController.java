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

    /**
     * @param store
     * @param menu
     * @param inventory
     * @param in
     */
    public static void helpPage(Store store, Menu menu, Inventory inventory, Scanner in){
        System.out.println("What aspect of the store would you like to know about?" 
                + "\n a. Basic Infomation" 
                + "\n b. Menu"
                + "\n c. Inventory"
                + "\n d. Game Process");
        handleInput.handleHelpPageInput(store, menu, inventory, in, true);
    }

    /**
     * @return
     */
    public static String description(){
        String description = ("- Your business will be run on a day to day basis, during the day you will make orders to earn money, and at the end of the day you will have the opportunity to review your bills, extend your opening hours, and c inventory!" 
        + "\n - openingTime represents the total opening hour of your store. You will earn more money with longer opening time per day. The maximum value is 10 hours and each extra hour costs 20.00." + "\n - The goal of your game is to imrpove your store to achieve daily goal for 7 days!");
        // System.out.println("equipment represents the equipments in your store. Better equipments brings higher income, and you can improve equipment by money. The maximum value is 10 points and each extra point costs 300.00.");
        // System.out.println("- technique represents your technique of making orders. Better technique enhance income as well as satisfaction from customers. The maximum value is 10 points and you can improve technique by reaching goals in income.");
        // System.out.println("- cleaniness represents the environment of your store. The more dirty your store is, the less customers you will take. The maximum value is 10 points and you need to close your store to take a deep clean.");
        // System.out.println("- satisfaction represents the feedback from customers. You can gain more tips with better satisfaction. The maximum value is 5.0 and it consists of all factors of your store.");
        return description;
    }

    /**
     * @param store
     * @param menu
     * @param inventory
     * @param dailyReceipt
     * @return
     */
    public static double dailyOrder(Store store, Menu menu, Inventory inventory, Hashtable<Integer, String> dailyReceipt) {
        double dailyIncome = 0;
        int openingTime = store.getOpeningTime();
        for (int time = 1; time <= openingTime; time++) {
            MenuItem order = menu.getRandomMenuItem();
            String name = order.getName();
            double price = order.getPrice();
    
            if (orderAvailability(inventory, order)) {
                dailyIncome += price;
                updateInventory(inventory, order);
                dailyReceipt.put(time, name + "\t " + price);
            } else {
                String identifier = orderAvailabilityIdentifier(order, inventory);
                dailyReceipt.put(time, "Insufficient inventory (" + identifier + " )\t " + "0.0");
            }
        }
        return dailyIncome;
    }
    
    /**
     * @param inventory
     * @param order
     * @return
     */
    private static boolean orderAvailability(Inventory inventory, MenuItem order) {
        return inventory.getCup() >= 1 && 
               inventory.getMilk() >= order.getMilk() && 
               inventory.getTea() >= order.getTea() && 
               (!order.isBoba() || inventory.getBoba() >= 1);
    }

    /**
     * @param order
     * @param inventory
     * @return
     */
    private static String orderAvailabilityIdentifier(MenuItem order, Inventory inventory) {
        StringBuilder identifier = new StringBuilder();
        if (inventory.getCup() < 1) {
            identifier.append(" cup");
        } 
        if (inventory.getMilk() < order.getMilk()) {
            identifier.append(" milk");
        } 
        if (inventory.getTea() < order.getTea()) {
            identifier.append(" tea");
        } 
        if ((order.isBoba() && inventory.getBoba() < 1)) {
            identifier.append(" boba");
        };
        return identifier.toString();
    }
    
    /**
     * @param inventory
     * @param order
     */
    private static void updateInventory(Inventory inventory, MenuItem order) {
        inventory.setCup(inventory.getCup() - 1);
        inventory.setMilk(inventory.getMilk() - order.getMilk());
        inventory.setTea(inventory.getTea() - order.getTea());
        if (order.isBoba()) {
            inventory.setBoba(inventory.getBoba() - 1);
        }
    }  

    /**
     * @param day
     * @param dailyReceipt
     * @param dailyIncome
     * @return
     */
    public static String getReceipt(Integer day, Hashtable<Integer, String> dailyReceipt, double dailyIncome){
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

    /**
     * @param inventory
     * @param menu
     * @param store
     * @param dailyIncome
     * @param in
     */
    public static void manageTab(Inventory inventory, Menu menu, Store store, double dailyIncome, Scanner in){
        store.setBalance(store.getBalance() + dailyIncome); 
        boolean loop = true;
        System.out.println("You've earned " + dailyIncome + " today and your store balance is " + store.getBalance() + " ! How do you want to manage your store?" );
        while (loop) {
            loop = handleInput.handleManageInput(store, menu, inventory, in, loop);
        }
    }    

    /**
     * @param totalReceipt
     * @return
     */
    public static String getTotalReceipt(Hashtable<Integer, Double> totalReceipt){
        StringBuilder receipt = new StringBuilder();
        receipt.append("\nReceipt Records: ");
        receipt.append("\n----------------\n");
        for (Integer key : totalReceipt.keySet()) {
            receipt.append("Day ").append(key).append(": ").append(totalReceipt.get(key)).append("\n");
        }
        receipt.append("----------------\n");
        return receipt.toString();
    }

    /**
     * @param store
     * @param inventory
     * @param totalReceipt
     */
    public static void finalResult(Store store, Inventory inventory, Hashtable<Integer, Double> totalReceipt){
        String storeInfo = store.getStoreInfo();
        String inventoryList = inventory.getInventoryList();
        String gameRecord = gameController.getTotalReceipt(totalReceipt);
        System.out.println("Here's a summary of your game records. We hope you've enjoyed the game!");
        System.out.println(storeInfo);
        System.out.println(inventoryList);
        System.out.println(gameRecord);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * Initialization
         */
        Store bobaStore = new Store("Boba Fever");
        String storeName = bobaStore.getName();
        Inventory inventory = new Inventory();
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Small Milk Tea", 1, 1, false, false, 4.00));
        menu.addMenuItem(new MenuItem("Large Milk Tea",2, 1, true, false, 6.00));
        menu.addMenuItem(new MenuItem("Small Boba Milk Tea",1, 1, false, true, 5.00));
        menu.addMenuItem(new MenuItem("Large Boba Milk Tea",2, 1, true, true, 7.50));
        menu.addMenuItem(new MenuItem("Small Milk with Boba",0, 2, false, true, 5.00));
        menu.addMenuItem(new MenuItem("Large Milk with Boba",0, 3, true, true, 7.50));
        handleInput handle = new handleInput();
        Hashtable<Integer, Double> totalReceipt= new Hashtable<>();
        Scanner in = new Scanner (System.in);

        /*
         * Welcome
         */
        System.out.println("\nWelcome to Boba Fever! Get ready to fulfill customer orders and keep your business running to survive for a week!");
        System.out.print("The initial store is named " + storeName + ". ");
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
                totalReceipt.put(day, dailyIncome);

                if (dailyIncome < dailyGoal) {
                    System.out.println("Today's goal was not achieved. Game Over!\n");
                    gameController.finalResult(bobaStore, inventory, totalReceipt);
                    break; 
                } else {
                    System.out.println("Congratulations! You achieved today's goal! Let's switch to the management tab...\n");
                    gameController.manageTab(inventory, menu, bobaStore, dailyIncome, in);
                }
            gameController.finalResult(bobaStore, inventory, totalReceipt);
            }
        }
    in.close();
    }
}