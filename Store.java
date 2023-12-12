/*
 * Represents the store
 */

import java.util.Scanner;

public class Store {
    /*
     * attributes
     */
    public String name;
    // public double income;
    // public double cost;
    public double balance;
    public int openingTime;
    // public int equipment;
    // public int technique;
    // public int cleanliness;
    // public double satisfaction;

    /*
     * constructor that build a store in default value
     * @param   name    store name  
     */
    public Store(String name){
        this.name = name;
        this.balance = 0;
        this.openingTime = 5;
        // this.equipment = 0;
        // this.technique = 0;
        // this.cleanliness = 10;
    }

    /*
     * mutator of store name
     * @param   name    new name of the store
     */
    public void setName(Scanner in){
        System.out.println("Enter name for your store: ");
        String newName = in.next();
        this.name = newName;
        System.out.println("Update successful! Your store name is " + this.name + " now.");
    }

    /*
     * method to extend opening time
     * @param hours number of hour that player wants to extend
     * @return  OpeningTime new opening time
     * @return  Balance     new balance
     */
    public void extendOpeningTime(int hours, Scanner in) {
        System.out.println("Enter number of hours you want to extend: ");
        int value = in.nextInt();
        if (this.openingTime == 10) {
            System.out.println("The opening hour of the store is updated to maximum! You have made great progress.");
        } else if (this.openingTime + hours <= 10) {
            this.openingTime += value;
            this.balance = balance - value*100;
            System.out.println("You spend" + value*100 + "to extend your store's opening time! You can take" + openingTime + "orders per day and your balance is" + balance + ".");
        } else {
            System.out.println("The number you have entered may have exceeded the upgrade limit, please try again.");
        }
    }

    // /*
    //  * method to improve equipment
    //  * @param hours number of hour that player wants to extend
    //  * @return  OpeningTime new opening time
    //  * @return  Balance     new balance
    //  */
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

    // /*
    //  * method to improve technique
    //  * @param hours number of hour that player wants to extend
    //  * @return  OpeningTime new opening time
    //  * @return  Balance     new balance
    //  */
    // public void improveTechnique() {
    //     if (income >= 10) {
    //         this.technique = 1;
    //     }
    //     else if (income >= 50) {
    //         this.technique = 2;
    //     }
    //     else if (income >= 100) {
    //         this.technique = 3;
    //     }
    //     else if (income >= 200) {
    //         this.technique = 4;
    //     }
    //     else if (income >= 300) {
    //         this.technique = 5;
    //     }
    //     else if (income >= 500) {
    //         this.technique = 6;
    //     }
    //     else if (income >= 700) {
    //         this.technique = 7;
    //     }
    //     else if (income >= 1000) {
    //         this.technique = 8;
    //     }
    //     else if (income >= 1500) {
    //         this.technique = 9;
    //     }
    //     else if (income >= 2000) {
    //         this.technique = 10;
    //     }
    // }

    // /*
    //  * method to improve cleaniness
    //  * @param hours number of hour that player wants to extend
    //  * @return  OpeningTime new opening time
    //  * @return  Balance     new balance
    //  */
    // public void improveCleanliness() {
    //     Scanner in = new Scanner (System.in);
    //     System.out.println("Do you want to take a day off for deep cleaning? This will resume your cleanliness points back to 10. (yes/no)");
    //     String value = in.next();
    //     if ("yes".equalsIgnoreCase(value)) {
    //         System.out.println("The equipment of the store is updated to maximum! You have made great progress.");
    //         // !!function to skip the day and show result with clenainess back to 10.
    //         in.close();
    //     }
    // }

    // public void updateSatisfaction(){
    //     double value = cleanliness*-0.1 + technique*0.05 + 2.5;
    //     this.satisfaction = value;
    // }

    /*
     * Method that print out all attributes and value of a store
     */
    public String getstoreInfo() {
        String storeInfo =  "Store Information: \n" + "----------------"
                                    + "\nName: " + this.name
                                    + "\nBalance: " + this.balance 
                                    + "\nOpening Time: " + this.openingTime + "\n----------------";
            return storeInfo;
        }
}