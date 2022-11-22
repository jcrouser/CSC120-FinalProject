/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Player
*/
import java.util.ArrayList;

public class Player {
    public ArrayList<Object> inventory = new ArrayList<Object>();
    
    public Player (String name, int numPockets) {
        System.out.println("A new player has been built. Their name is " + name + ". They have " + numPockets + "inventory spaces.");
    }
}
