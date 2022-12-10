/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Car manages and keeps track of passengers in each car with a hashmap called carPassengers.
*/
import java.util.HashMap;
import java.util.*;

public class Car {
  //with the way i set this up, each car has it's own hashmap. each hashmap stores all the passengers in the car. key=name, value=passenger object
  HashMap<String, Passenger> carPassengers = new HashMap<String, Passenger>();
  HashMap<String, Item> carItems = new HashMap<String, Item>();
  ArrayList<String> methods = new ArrayList<String>();
  public boolean doorOpen = false;
  public String carItemsString;

  //Constructor makes a new car
  public Car(){}

  //Method getter for accessing information about any passenger by name
  public Passenger getPassenger(String name) {
      Passenger p = carPassengers.get(name);
      return p;
  }

  //Method adds passengers to the hashmap
  public void addPassenger(String name, String description, String dialogue) {
      Passenger p = new Passenger(name, description, dialogue); //make a new passenger and temporarily label it passenger "p"
      carPassengers.put(p.name, p); //add the new passenger to the hashmap. from here-on-out it will be labelled by its name, not p, since the hashmap key=name
  }

  public void addItem(String name, String description){
      Item i = new Item(name, description);
      carItems.put(i.name, i);
  }

  public String printItems() {
    if (carItems.size() == 0) {
      //System.out.println("No items in this car.");
      return "No items in this car.";
    }
    if (carItems.size() == 1) {
      carItemsString = "The item in this car is: " + carItems.keySet();
      return carItemsString;
    } else { // (carItems.size() > 1) {
      carItemsString = "The items in this car are: " + carItems.keySet();
      return carItemsString;
    }
  }
}