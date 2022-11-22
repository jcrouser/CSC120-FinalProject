/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Train creates a train that has three cars, and keeps track of them in an arraylist called "cars"
*/
import java.util.ArrayList;

public class Train {
    public ArrayList<Car> cars = new ArrayList<Car>();


    public Train(){
        Car carOne = new Car();
        Car carTwo = new Car();
        Car carThree = new Car();

        cars.add(carOne);
        cars.add(carTwo);
        cars.add(carThree);
        System.out.println("The train has been built.");
    }
}
