import java.util.ArrayList;
import java.util.InputMismatchException;

public class Shopper {

    private ArrayList<String> groceryList;
    private double budget;
    private Cart cart;
    private int location;

    public Shopper(){
        this.groceryList = new ArrayList<String>();
        this.budget = 0;
        this.cart = new Cart();
        this.location = 0;
    }

    public boolean setBudget(String budget){
        try{
            this.budget = Double.parseDouble(budget);
            if(this.budget <= 0){
                throw new InputMismatchException();
            } 
            else{
                return true;
            }
        } catch (Exception a){
            System.out.println("Invalid input.");
            System.out.println("Budget must be greater than $0 and input may not contain any characters besides decimals and numbers.");
            return false;
        }  
    }

    public double getBudget(){
        return this.budget;
    }

    public int getLocation(){
        return this.location;
    }


    public void addToList(String item){
        groceryList.add(item.toLowerCase());
    }

    public void removeFromList(String item){
        groceryList.remove(item.toLowerCase());
    }

    public void enterStore(){
        this.location = 1;
        System.out.println("You have entered the store! You are in Aisle 1: The grocery aisle.");
    }

    public boolean goToAisle(int aisle){
        if(this.location == 0){
            System.out.println("You are outside the store. Please enter the store.");
            return false;
        }
        else{
            this.location = aisle;
            System.out.println("You are now in aisle " + aisle ".");
            return true;
        }
    }
    
}
