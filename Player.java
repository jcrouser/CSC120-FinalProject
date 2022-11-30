/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Player. The user can call all these methods. That's how they play the game.
*/
import java.util.HashMap;

public class Player {
    HashMap<String, Item> inventory = new HashMap<String, Item>();
    Train train;
    int location;

    public Player (String name, int numPockets, Train train) {
        this.train = train;
        location=0;
        System.out.println("A new player has been built. Their name is " + name + ". They have " + numPockets + "inventory spaces.");
    }

    //for loading stuff into the players pockets at the start of the game
    public void givePlayer(String name, String description) {
        Item i = new Item(name, description);  //i is the ever-new item
        inventory.put(i.name, i); //store i in the hashmap with its name as the key
    }

    //Boolean: If holding item, then return true
    public boolean holding(String name){
        if (inventory.containsKey(name)) {
            System.out.println("You are in possession of the " + name + ".");
            return true;
        } else {
            System.out.println("You are NOT in possession of the " + name + ".");
            return false;
        }
    }

    //For simplicity, I'm making it so every car is one space long. Also, location=0 is the furthest back car (where the player starts). The front-most car is car 2.
    public void nextCar(){
        if (location<2) {
            location ++;
            System.out.println("You are now in the next car.");
        } else {
            System.out.println("You are in the front-most car. You cannot move forward.");
        }
    }

    public void previousCar(){
        if (location>0) {
            location --;
            System.out.println("You have moved back a car.");
        } else {
            System.out.println("You are in the furthest back car. You cannot move backwards.");
        }
    }

    public void talkTo(String name) {
        if (train.cars[location].carPassengers.containsKey(name)) {
            Passenger p = train.cars[location].getPassenger(name);
            System.out.println(name + ": \"" + p.dialogue + "\"\n");
        } else {
            System.out.println(name + " is not in this car.\n");
        }
    }

    public void lookAround(){
        if (location == 0) {
            System.out.println("--DESCRIPTION OF CAR 0--");
        } if (location == 1) {
            System.out.println("--DESCRIPTION OF CAR 1--");
        } if (location == 2) {
            System.out.println("--DESCRIPTION OF CAR 2--");
        } else {
            System.out.println("You are in the void. Restart game or try to fix your location.");
            System.out.println("Your location is: " + location);
        }
    }

    public void pickUp(String itemName) {
        if(train.cars[this.location].carItems.containsKey(itemName)) {
            Item i = train.cars[this.location].carItems.get(itemName);
            inventory.put(itemName, i);
            System.out.println("You pocket the " + itemName + ".");
        } else {
            System.out.println("Item not found.");
        }
    }
}
