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
    Scanner in = new Scanner (System.in);

    public void description(){
        System.out.println("- Your business will be run on a day to day basis, during the day you will make orders to earn money, and at the end of the day you will have the opportunity to review your bills, extend your opning hours, and restock inventory!");
        System.out.println("- openingTime represents the total opening hour of your store. You will earn more money with longer opening time per day. The maximum value is 10 hours and each extra hour costs 50.00.");
        // System.out.println("equipment represents the equipments in your store. Better equipments brings higher income, and you can improve equipment by money. The maximum value is 10 points and each extra point costs 300.00.");
        // System.out.println("- technique represents your technique of making orders. Better technique enhance income as well as satisfaction from customers. The maximum value is 10 points and you can improve technique by reaching goals in income.");
        // System.out.println("- cleaniness represents the environment of your store. The more dirty your store is, the less customers you will take. The maximum value is 10 points and you need to close your store to take a deep clean.");
        // System.out.println("- satisfaction represents the feedback from customers. You can gain more tips with better satisfaction. The maximum value is 5.0 and it consists of all factors of your store.");
        System.out.println("- The goal of your game is to imrpove your store to acheive daily goal for 7 days!");
    }

    public void getReceipt(){
        System.out.println("----------------");
        System.out.println("Day " + day);
        System.out.println("----------------");
        System.out.println("null");        
    }

    public void manageTab(Inventory inventory, Store store, double dailyIncome){
        store.balance += dailyIncome;
        String loop = "yes";

        while ("yes".equalsIgnoreCase(loop)) {
            System.out.println("You worked very hard today! How do you want to manage your store? (a/b)" 
                + "\n a. Check inventory and restock" 
                + "\n b. Extend opening hour");
            String response = in.next();

            switch (response.toLowerCase()) {
                case "a":
                inventory.restock(store, in);
                break;
                
                case "b":
                System.out.println("Enter number of hours that you want to extend (50.00/hour): ");
                Integer number = in.nextInt();
                store.extendOpeningTime(number, in);
                break;
                
                default:
                System.out.println("Invalid answer.");
                return; 
            }
            System.out.println("Do you have other tasks to complete? (yes/no)");
            loop = in.next();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * initialization
         */
        Store bobaStore = new Store("Boba Fever");
        Inventory inventory = new Inventory();
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Small Milk Tea", 2, 1, false, false, 4.50));
        menu.addMenuItem(new MenuItem("Large Milk Tea",2, 1, true, false, 5.00));
        menu.addMenuItem(new MenuItem("Small Boba Milk Tea",2, 1, false, true, 5.00));
        menu.addMenuItem(new MenuItem("Large Boba Milk Tea",2, 1, true, true, 5.00));
        menu.addMenuItem(new MenuItem("Small Milk with Boba",0, 1, false, true, 5.00));
        menu.addMenuItem(new MenuItem("Large Milk with Boba",0, 1, true, true, 5.00));
        Scanner in = new Scanner (System.in);

        /*
         * Welcome
         */
        System.out.println("\nWelcome to the Boba Fever game! Prepare orders for customers to run your business and survive a week!");
        System.out.print("\nThe name of the initial store is " + bobaStore.name + ". Do you want to rename it? (yes/no)");
        String response = in.next();
        if ("yes".equalsIgnoreCase(response)) {
            bobaStore.setName(in);
        }

        /*
         * Print store information and rules
         */
        String storeInfo = bobaStore.getstoreInfo();
        System.out.println("\nNow, let's take a look at your store: \n" + storeInfo);
        String menuList = menu.getMenuList();
        System.out.println("\n" + menuList);
        String inventoryList = inventory.getInventoryList();
        System.out.println("\n"+ inventoryList);

        /*
         * print out description and process of the game
         */
        System.out.println("\nAnd here is the description of how to run your store: ");
        gameController.description();
        System.out.println("\nAre you ready? Let's begin.\n");

        /*
         * 
         */
        for (int day = 1; day <= days; day++) {
            double dailyIncome = 0;
            double dailyGoal = Math.pow(day, 2);
            Hashtable<Integer, String> dailyReceipt = new Hashtable<>();
            System.out.println("Goal of day " + day + ": " + dailyGoal);
            for (int time = 1; time <= bobaStore.openingTime; time++) {
                MenuItem order = menu.getRandomMenuItem();
                String name = order.name;
                double price = order.price;

                if (inventory.cup >= 1 && inventory.milk >= order.milk && inventory.tea >= order.tea) {
                    if (order.boba) {
                        if (inventory.boba >= 1) {
                            dailyIncome += price;
                            inventory.cup -= 1;
                            inventory.milk -= order.milk;
                            inventory.tea -= order.tea;
                            inventory.boba -= 1;
                            dailyReceipt.put(time, name + ", " + price);
                            System.out.println("You earned " + price + " from " + name + " !");
                        }
                        else {
                            System.out.println("Insufficient inventory! You need to refund this order to customer.");
                        }
                    }
                    else {
                        dailyIncome += price;
                        inventory.cup -= 1;
                        inventory.milk -= order.milk;
                        inventory.tea -= order.tea; 
                        dailyReceipt.put(time, name + ", " + price);
                        System.out.println("You earned " + price + " from " + name + " !");
                    }
                }
                else {
                    System.out.println("Insufficient inventory! You need to refund this order to customer.");
                }
            }
            System.out.println("\nCheck your receipt: \n" + "----------------");
            for (Integer key : dailyReceipt.keySet()) {
                System.out.println("Order " + key + ": " + dailyReceipt.get(key));
            }
            System.out.println("----------------\n" + "Total income: " + dailyIncome + "\n----------------\n");

            if (dailyIncome < dailyGoal) {
                System.out.println("Today's goal was not achieved. Game Over!");
                break; 
            } else {
                System.out.println("Congratulations! You achieved today's goal! Switching to managing tab...\n");
                gameController.manageTab(inventory, bobaStore, dailyIncome);
            }
        }
    in.close();
    }
}