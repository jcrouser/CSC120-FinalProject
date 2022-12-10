/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Train creates a train that has three cars, and keeps track of them in an array called "cars"
*/
public class Train {
  public Car[] cars = new Car[4];

  public Train() {
    cars[0] = new Car();
    cars[1] = new Car();
    cars[2] = new Car();
    cars[3] = new Car();
  }
}
