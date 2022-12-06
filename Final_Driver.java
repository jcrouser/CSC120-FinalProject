import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;;

public class Final_Driver {
    public static void main(String[] args){

        //Flag for when game should end
        boolean playing = true;
        boolean valid = true;
        //Scanner object for user input
        Scanner keyboard = new Scanner(System.in);
        //Store user response
        String response = "";

        //Intro message
        System.out.println("**************************************************");
        System.out.println("WELCOME TO GRACE'S REASONABLY PRICED GROCERY STORE!");
        System.out.println("***************************************************");
        //Instatiate GroceryStore
        //Instatiate Shopper
        Shopper user = new Shopper();

        do{
            //Prompt user for budget
            System.out.println("First, what is your budget for groceries?");
            System.out.println("Please enter your budget in dollars and cents in decimal format without any extra characters.");
            do{
                response = keyboard.nextLine();
                valid = user.setBudget(response);
            }while(!valid);

            //Prompt user to enter grocery list
            System.out.printf("Great, your budget is $%.2f.", user.getBudget()); 
            System.out.println();
            System.out.println("Enter items on your list. Enter DONE when you are finished making your list");
            //while loop taking in input and adding to list until user enters "done"
            response = keyboard.nextLine();
            while(!response.toUpperCase().equals("DONE")){
                user.addToList(response);
                response = keyboard.nextLine();
            }

            System.out.println("Enter the grocery store to get started.");
            response = keyboard.nextLine();

            while(!response.toUpperCase().equals("ENTER")){
                if(response.toUpperCase().equals("QUIT")){
                    System.out.println("You have quit the game.");
                    System.exit(0);
                }
                else{
                    System.out.println("ERROR! Please enter store to get started.");
                    response = keyboard.nextLine();
                }
            }
            user.enterStore();

            //BRUH FIGURE OUT HOW TO CHECK COMMANDS
            System.out.println("Time to get shopping!");
            System.out.println("Your available commands are: LIST, ADD, PRICE, ");

        }while(playing);
    }
    
}
