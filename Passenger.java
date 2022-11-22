/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Passenger simply creates passengers which each have a name, description, and one peice of dialogue
*/
public class Passenger {
    String name;
    String description;
    String dialogue;

    public Passenger(String name, String description, String dialogue) {
        this.name = name;
        this.description = description;
        this.dialogue=dialogue;
        System.out.println("A passenger has been built. Their name is " + name + ".");
    }

    
}



    
