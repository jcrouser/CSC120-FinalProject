
/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Player. The user can call all these methods. That's how they play the game.
*/
import java.util.HashMap;
//import java.util.*;

public class Player {
  HashMap<String, Item> inventory = new HashMap<String, Item>();
  Train train;
  int location;
  int nConvos; // how many times you've talked to a passenger

  public Player(String name, int numPockets, Train train) {
    this.train = train;
    location = 0;
  }

  // for loading stuff into the players pockets at the start of the game
  public void givePlayer(String name, String description) {
    Item i = new Item(name, description); // i is the ever-new item
    inventory.put(i.name, i); // store i in the hashmap with its name as the key
  }

  // Boolean: If holding item, then return true
  public boolean holding(String name) {
    if (inventory.containsKey(name)) {
      System.out.println("\nYou are in possession of the " + name + ".\n");
      return true;
    } else {
      System.out.println("\nYou are NOT in possession of the " + name + ".");
      return false;
    }
  }

  public boolean metPassengers() {
    if (nConvos >= train.cars[location].carPassengers.size()) {
      return true;
    } else {
      return false;
    }
  }

  // For simplicity, I'm making it so every car is one space long. Also,
  // location=0 is the furthest back car (where the player starts). The front-most
  // car is car 2.
  public void nextCar() {
    if (location <= 1) {
      location++;
      if (location < 2) {
        System.out.println("\n" + "You are now in the next car.");
        lookAround();
      }
      if (location == 2) {
        lookAround();
        System.out.println("\n" + "You are immediately surprised by the conductor, who grabs your shoulders and shakes you...");
        talkTo("CONDUCTOR");
      }
    } else {
      System.out.println("You are in the front-most car. You cannot move forward within the train.\n");
    }
  }

  public void previousCar() {
    if (location > 0) {
      location--;
      System.out.println("\n" + "You have moved back a car.");
      lookAround();
    } else {
      System.out.println("You are in the furthest back car. You cannot move backwards.\n");
    }
  }

  public void exitTrain() {
    if (location == 2) {
      location++;
      System.out.println("\n" + "You are now outside of the train. ");
      lookAround();
    } else {
      System.out.println("You can't exit the train from this car");
    }
  }

  public void talkTo(String name) {
    if (train.cars[location].carPassengers.containsKey(name)) {
      Passenger p = train.cars[location].getPassenger(name);
      System.out.println("\n" + name + ": \"" + p.dialogue + "\"\n");
      this.nConvos++;
    } else {
      System.out.println(name + " is not in this car.\n");
    }
  }

  public void lookAround() {
    if (location >= 0 && location <= 3) {
      if (location == 0) { // description of car 0
        System.out.println("\n" +
        "You are in the main cabin of the train.\n It smells of coffee and the seats are upholstered with a comfortable purple velvet.\n" +
        " There is a calm air about. Around you there are people seated:" + train.cars[location].carPassengers.keySet() +
        ".\n There is a keycard on the ground where the conductor dropped it, and in your lap sits a pair of glasses. " +
        train.cars[location].printItems() + "\n");
      }
      if (location == 1) { // description of car 1
        System.out.println("\n" +
        "Your eyes have had to adjust since the previous car, but you see around you a shell of the first car.\n" +
        " Stands of hay litter the floor and the walls are coated in a green/brown petina from what looks like decades of water damage.\n" +
        " The car is essentially just a hollow tin box, and tremendous noise rattles it from the train chugging along.\n" +
        " The floor vibrates your whole body, causing all your bones to rattle about inside you.\n");
      }
      if (location == 2) { // description of car 2
        System.out.println("\n" +
        "You enter the locomotive-- the engine room of the train.\n" +
        " It is extremely loud, and coal is glowing red and billowing smoke from out of the furnace.\n" +
        " There is a door to exit the train, and the conductor, in great distress, is standing at the window.\n" +
        " Through the window you see a great furry beast completely obstructing the tracks,\n" +
        " and strange wooden poles reaching from the ground up past where you can see.\n");
      }
      if (location == 3) { // description of outside
        System.out.println("\n" + 
        "You are on the ground, which is cold and hard.\n" +
        " You look up and see that the wooden poles connect to a seat which you recognize as a giant chair.\n" +
        " You slowly realize that the chair is actually proportional to everything else in the room:\n" +
        " a giant clock, a giant table, a giant door, etc.\n You see a large cylindrical object with a button on it that says 'Laser'.\n" +
        " Looking to your right, the beast grows visibly restless, eyes snapping to the train and its inhabitants.\n" +
        " Whatever you do, you know you must do it quickly.\n");
      }
    } else {
      System.out.println("You are in the void. Exit game or try to fix your location.");
      System.out.println("Your location is: " + location + "\n");
    }
  }

  public void pickUp(String itemName) {
    if (train.cars[this.location].carItems.containsKey(itemName)) {
      Item i = train.cars[this.location].carItems.get(itemName);
      inventory.put(itemName, i); // place into player inventory
      train.cars[this.location].carItems.remove(itemName); // remove from carItems
      System.out.println("\n" + "You pocket the " + itemName + ".\n");
    } else {
      System.out.println("Please enter valid item name.\n");
    }
  }

  public void drop(String itemName) {
    if (this.inventory.containsKey(itemName)) {
      Item i = inventory.get(itemName); // RYAN: does this happen in the right order? or is it necessary?
      this.inventory.remove(itemName); // remove from inventory
      train.cars[this.location].carItems.put(itemName, i); // place back in car
      System.out.println("\n" + "You have dropped the " + itemName + ".\n");
    } else {
      System.out.println("Please enter valid item name.\n");
    }
  }

  public void inspect(String name) {
    // if item/person exists in game
    if (train.cars[this.location].carItems.containsKey(name) || inventory.containsKey(name)
        || train.cars[this.location].carPassengers.containsKey(name)) {
      if (train.cars[this.location].carItems.containsKey(name)) { // exists: if item in current car
        Item i = train.cars[this.location].carItems.get(name);
        System.out.println("\n" + i.description + "\n");
      }
      if (inventory.containsKey(name)) { // exists: if item in inventory
        Item i = inventory.get(name);
        System.out.println("\n" + i.description + "\n");
      }
      if (train.cars[location].carPassengers.containsKey(name)) { // exists: if person in carPassengers
        Passenger p = train.cars[this.location].carPassengers.get(name);
        System.out.println("\n" + p.description + "\n");
      }
    } else { // doesn't exist
      System.out.println("There is no item called " + name + " here.\n");
    }
  }

  public void checkPockets() {
    System.out.println("\nYou find: " + this.inventory.keySet() + "\n");
  }

  public void help() {
    System.out.println("\nYou transcend your bodily form and connect to the great beings of the realm: Janna, Ryan, & Chelsea.\n" +
    "They bestow upon you the wisdom of available action.");
    System.out.println(train.cars[location].methods + "\n");
  }

  public void use(String object){
    if (object.equals("LASER")){
      System.out.println("Fearlessly, you grab the laser pointer and use all of your weight to press the large button on it's side.\n" + "A strong red beam shoots from one end, casting a bright red dot which you notice immediately captures the beast's attention.\n" + "Using the force of your sheer strength and adrenaline you slowly shift the front of the laser to move the dot's location away from the tracks.\n" + "The beast eagerly follows the dot, swatting and pouncing with it's massive dangerous paws. You've done it! You've saved the train!");
    }else{
      System.out.println("This object cannot be used.");
    }
  }
}


