/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Game runs the main game
*/
public class Game {
    
    public static void main(String[] args) {
        Train train = new Train();

        train.cars.get(0).addPassenger("Linda", "long flowy red hair and a few freckles, and is looking absently out the window.", "Hello young man; you look confused. Haha, aren't we all. Why don't you go talk to my son Anton. He's about your age.");
        train.cars.get(0).addPassenger("William", "courdouroy pants, a cotton t-shirt, and is smoking a pipe.", "My great grandmother told me of a beast that lurks these tracks. You don't believe in such things though, do you?");
        train.cars.get(0).addPassenger("Anton", "a cozy hoodie with headphones and is reading a book.", "I saw you stole that keycard. Whatever you're up to, I get half, okay?");

        System.out.println("\n<<<<o>  Welcome to ZONK  <o>>>>\n");
    }

}