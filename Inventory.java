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
        this.cup = 10;
        this.tea = 10;
        this.milk = 10;
        this.boba = 10;
        this.cupBuyIn = 0.5;
        this.teaBuyIn = 1;
        this.milkBuyIn = 1;
        this.bobaBuyIn = 0.5;
    }

    /*
     * accessor of inventory
     */
    public String getInventoryList() {
        String inventoryList = "\nCurrent Inventory:\n" +"----------------\n"
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
    public void restock(Store store, String input, int number, Scanner in){
        boolean response;
        switch (input) {
            case "a":
                if (store.balance >= cupBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.balance -= cupBuyIn * number;
                        this.cup += number;
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
    
            case "b": 
                if (store.balance >= teaBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.balance -= teaBuyIn * number;
                        this.tea += number;
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
    
            case "c": 
                if (store.balance >= milkBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.balance -= milkBuyIn * number;
                        this.milk += number;
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
    
            case "d": 
                if (store.balance >= bobaBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.balance -= bobaBuyIn * number;
                        this.boba += number;
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
    
            default:
                System.out.println("Invalid input.");
                break;
        }
    
        
    }
}

