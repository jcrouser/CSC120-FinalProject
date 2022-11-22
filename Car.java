/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Car manages and keeps track of passengers in each car with a hashmap called carPassengers.
*/
import java.util.HashMap;

public class Car {
    //with the way i set this up, each car has it's own hashmap. each hashmap stores all the passengers in the car. key=name, value=passenger object
    HashMap<String, Passenger> carPassengers = new HashMap<String, Passenger>();

    //Constructor makes a new car
    public Car() {
        System.out.println("A new car has been built.");
    }

    //Method getter for accessing information about any passenger by name
    public void getPassenger(String name) {
        Passenger p = carPassengers.get(name);
        System.out.println(p.description);
    }

    //Method adds passengers to the hashmap
    public void addPassenger(String name, String description, String diologue) {
        Passenger p = new Passenger(name, description, diologue); //make a new passenger and temporarily label it passenger "p"
        carPassengers.put(p.name, p); //add the new passenger to the hashmap. from here-on-out it will be labelled by its name, not p, since the hashmap key=name

        System.out.println(name + " has " + description);
    }
}
