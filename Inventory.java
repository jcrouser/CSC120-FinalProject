/*
 * Tracks the restaurant's inventory of ingredients and supplies
 */
import java.util.Scanner;

public class Inventory {
    /*
     * attributes
     */
    private int cup;
    private int tea;
    private int milk;
    private int boba;
    private double cupBuyIn;
    private double teaBuyIn;
    private double milkBuyIn;
    private double bobaBuyIn;

    /**
     * Setter of cup
     * @param cup
     */
    public void setCup(int cup) {
        this.cup = cup;
    }

    /**
     * Setter of tea
     * @param tea
     */
    public void setTea(int tea) {
        this.tea = tea;
    }

    /**
     * Setter of milk
     * @param milk
     */
    public void setMilk(int milk) {
        this.milk = milk;
    }

    /**
     * Setter of boba
     * @param boba
     */
    public void setBoba(int boba) {
        this.boba = boba;
    }

    /**
     * getter of cup quantity
     * @return cup
     */
    public int getCup() {
        return cup;
    }

    /**
     * getter of tea quantity
     * @return tea
     */
    public int getTea() {
        return tea;
    }

    /**
     * getter of milk quantity
     * @return milk
     */
    public int getMilk() {
        return milk;
    }

    /**
     * getter of boba quantity
     * @return boba
     */
    public int getBoba() {
        return boba;
    }

    /**
     * getter of cup price
     * @return cupBuyIn
     */
    public double getCupBuyIn() {
        return cupBuyIn;
    }

    /**
     * getter of tea price
     * @return teaBuyIn
     */
    public double getTeaBuyIn() {
        return teaBuyIn;
    }

    /**
     * getter of milk price
     * @return milkBuyIn
     */
    public double getMilkBuyIn() {
        return milkBuyIn;
    }

    /** getter of boba price
     * @return bobaBuyIn
     */
    public double getBobaBuyIn() {
        return bobaBuyIn;
    }

    /*
     * constructor that create inventory with default value
     */
    public Inventory(){
        this.cup = 5;
        this.tea = 5;
        this.milk = 5;
        this.boba = 5;
        this.cupBuyIn = 0.5;
        this.teaBuyIn = 1;
        this.milkBuyIn = 1;
        this.bobaBuyIn = 0.5;
    }

    /**
     * accessor of inventory
     * @return inventoryList string that describes inventory
     */
    public String getInventoryList() {
        String inventoryList = "\nCurrent Inventory:\n" +"----------------\n"
                                    + "a. Cups: " + cup + "\tBuy in price: " + cupBuyIn 
                                    + "\nb. Tea: " + tea + "\tBuy in price: " + teaBuyIn 
                                    + "\nc. Milk: " + milk  + "\tBuy in price: " + milkBuyIn 
                                    + "\nnd. Boba: " + boba + "\tBuy in price: " + bobaBuyIn 
                                    + "\n----------------";
        return inventoryList;
    }

    /**
     * @param itemType
     * @param quantity
     * @return
     */
    public double restockCost(String itemType, int quantity) {
        switch (itemType) {
            case "a": 
                return cupBuyIn * quantity;
            case "b": 
                return teaBuyIn * quantity;
            case "c":
                return milkBuyIn * quantity;
            case "d":
                return bobaBuyIn * quantity;
            default:
                return 0;
        }
    }

    /**
     * method that restock in different cases
     * @param store
     * @param input
     * @param number
     * @param in
     */
    public void restock(Store store, String input, int number, Scanner in){
        boolean response;
        switch (input) {
            case "a":
                if (store.getBalance() >= cupBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.setBalance(store.getBalance() - cupBuyIn * number);
                        this.cup += number;
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
    
            case "b": 
                if (store.getBalance() >= teaBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.setBalance(store.getBalance() - teaBuyIn * number);
                        this.tea += number;
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
    
            case "c": 
                if (store.getBalance() >= milkBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.setBalance(store.getBalance() - milkBuyIn * number);
                        this.milk += number;
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
    
            case "d": 
                if (store.getBalance() >= bobaBuyIn * number) {
                    System.out.println("Purchase confirmed?");
                    response = handleInput.handleYesNoInput(in);
                    if (response) {
                        store.setBalance(store.getBalance() - bobaBuyIn * number);
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

