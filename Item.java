/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Item
*/
public class Item {
    String name;
    String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        System.out.println("A " + name + " has been built!");
    }
}
