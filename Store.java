/*
 * Represents the store
 */

import java.lang.reflect.Field;
import java.util.Scanner;

public class Store {
    /*
     * attributes
     */
    public String name;
    public double income;
    // public double cost;
    public double balance;
    public int openingTime;
    // public int equipment;
    public int technique;
    public int cleanliness;
    public double satisfaction;

    /*
     * constructor that build a store in default value
     * @param   name    store name  
     */
    public Store(String name){
        this.name = name;
        this.balance = 100;
        this.openingTime = 5;
        // this.equipment = 0;
        this.technique = 0;
        this.cleanliness = 10;
    }

    /*
     * accessor of store name 
     * @return  name    current name of the store
     */
    public String getName(){
        return name;
    }

    /*
     * mutator of store name
     * @param   name    new name of the store
     */
    public void setName(){
        Scanner inputName = new Scanner (System.in);
        System.out.println("Enter name for your store: ");
        String newName = inputName.next();
        this.name = newName;
        System.out.println("Update success! Your store name is " + this.name + " now.");
        inputName.close();
    }

    /*
     * accessor of store balance
     * @return  balance current balance of the store
     */
    public double getBalance(){
        return this.balance;
    }

    /*
     * accessor of store opening time
     * @return  openingTime current opening time of the store
     */
    public int getOpeningTime(){
        return openingTime;
    }

    /*
     * accessor of store balance
     * @return  equipment   current equiment of the store
     */
    // public int getEquipment(){
    //     return equipment;
    // }

    /*
     * accessor of store balance
     * @return  technique   current technique of the store
     */
    public int getTechnique(){
        return technique;
    }

    /*
     * accessor of store balance
     * @return  cleanliness current cleanliness of the store
     */
    public int getCleaniness(){
        return cleanliness;
    }

    /*
     * method to extend opening time
     * @param hours number of hour that player wants to extend
     * @return  OpeningTime new opening time
     * @return  Balance     new balance
     */
    public void extendOpeningTime(int hours) {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter number of hours you want to extend: ");
        int value = in.nextInt();
        if (this.openingTime == 10) {
            System.out.println("The opening hour of the store is updated to maximum! You have made great progress.");
        } else if (this.openingTime + hours <= 10) {
            this.openingTime += value;
            this.balance = balance - value*500;
            System.out.println("You spend" + value*500 + "to extend your store's opening time! You can take" + openingTime + "orders per day and your balance is" + balance + ".");
            in.close();
        } else {
            System.out.println("The number you have entered may have exceeded the upgrade limit, please try again.");
        }
    }

    /*
     * method to improve equipment
     * @param hours number of hour that player wants to extend
     * @return  OpeningTime new opening time
     * @return  Balance     new balance
     */
    // public void improveEquipment() {
    //     Scanner in = new Scanner (System.in);
    //     System.out.println("Enter number of points you want to improve for equipments: ");
    //     int value = in.nextInt();
    //     if (this.equipment == 10) {
    //         System.out.println("The equipment of the store is updated to maximum! You have made great progress.");
    //     }
    //     else if (this.equipment + value <= 10) {
    //         this.equipment += value;
    //         this.balance = balance - value*20;
    //         System.out.println("You spend" + value*20 + "to improve your store's equipment! Your equipements are" + equipment + "out of 10 and your balance is" + balance + ".");
    //         in.close();
    //     } else {
    //         System.out.println("The number you have entered may have exceeded the upgrade limit, please try again.");
    //     }
    // }

    /*
     * method to improve technique
     * @param hours number of hour that player wants to extend
     * @return  OpeningTime new opening time
     * @return  Balance     new balance
     */
    public void improveTechnique() {
        if (income >= 10) {
            this.technique = 1;
        }
        else if (income >= 50) {
            this.technique = 2;
        }
        else if (income >= 100) {
            this.technique = 3;
        }
        else if (income >= 200) {
            this.technique = 4;
        }
        else if (income >= 300) {
            this.technique = 5;
        }
        else if (income >= 500) {
            this.technique = 6;
        }
        else if (income >= 700) {
            this.technique = 7;
        }
        else if (income >= 1000) {
            this.technique = 8;
        }
        else if (income >= 1500) {
            this.technique = 9;
        }
        else if (income >= 2000) {
            this.technique = 10;
        }
    }

    /*
     * method to improve cleaniness
     * @param hours number of hour that player wants to extend
     * @return  OpeningTime new opening time
     * @return  Balance     new balance
     */
    public void improveCleanliness() {
        Scanner in = new Scanner (System.in);
        System.out.println("Do you want to take a day off for deep cleaning? This will resume your cleanliness points back to 10. (yes/no)");
        String value = in.next();
        if ("yes".equalsIgnoreCase(value)) {
            System.out.println("The equipment of the store is updated to maximum! You have made great progress.");
            // !!function to skip the day and show result with clenainess back to 10.
            in.close();
        }
    }

    public void updateSatisfaction(){
        double value = cleanliness*-0.1 + technique*0.05 + 2.5;
        this.satisfaction = value;
    }

    /*
     * Method that print out all attributes and value of a store
     */
    public void storeInfo() {
        Class<?> objClass = this.getClass(); 
        Field[] fields = objClass.getDeclaredFields();

        System.out.println("----------------");
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                Object fieldValue = field.get(this);
                System.out.println(fieldName + ": " + fieldValue);
            } catch (IllegalAccessException e) {
                System.err.println("Error accessing field: " + fieldName);
            }
        }
        System.out.println("----------------");
    }

    public void description(){
        System.out.println("Your business will be run on a day to day basis, during the day you will make orders to earn money, and at the end of the day you will have the opportunity to review your bills, upgrade your equipment, and decide on your plans for tomorrow's opening!");
        System.out.println("- openingTime represents the total opening hour of your store. You will earn more money with longer opening time per day. The maximum value is 10 hours and each extra hour costs 500.00.");
        // System.out.println("equipment represents the equipments in your store. Better equipments brings higher income, and you can improve equipment by money. The maximum value is 10 points and each extra point costs 300.00.");
        System.out.println("- technique represents your technique of making orders. Better technique enhance income as well as satisfaction from customers. The maximum value is 10 points and you can improve technique by reaching goals in income.");
        System.out.println("- cleaniness represents the environment of your store. The more dirty your store is, the less customers you will take. The maximum value is 10 points and you need to close your store to take a deep clean.");
        System.out.println("- satisfaction represents the feedback from customers. You can gain more tips with better satisfaction. The maximum value is 5.0 and it consists of all factors of your store.");
        System.out.println("The goal of your game is not to go bankrupt and to maintain as much positive feedback as possible!");
    }

}