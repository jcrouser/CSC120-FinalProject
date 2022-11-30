/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Game runs the main game
*/
import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        Train train = new Train();
        Player player = new Player("Laika",2, train);

        //(uncomment this stuff when we have a functioning gameloop)
        boolean stillPlaying = true;
        Scanner userInput = new Scanner(System.in);
        String userResponse = "";

        //populate cars with passengers
        train.cars[0].addPassenger("Linda", "long flowy red hair and a few freckles, and is looking absently out the window.", "Hello young man; you look confused. Haha, aren't we all. Why don't you go talk to my son Anton. He's about your age.");
        train.cars[0].addPassenger("William", "courdouroy pants, a cotton t-shirt, and is smoking a pipe.", "My great grandmother told me of a beast that lurks these tracks. You don't believe in such things though, do you?");
        train.cars[0].addPassenger("Anton", "a cozy hoodie with headphones and is reading a book.", "I saw you stole that keycard. Whatever you're up to, I get half, okay?");

        //load items into the cars
        train.cars[0].addItem("keycard", "A thin plastic card. The only parts you can read are \"Lionel...130 Peice");

        //load the player in with a pair of glasses
        player.givePlayer("glasses", "Large round spectacles. Carved on the inside are the letters \"LAIKA\".\n" +
        "You don't remember much about who you are or how you got here, but your fondness of these glasses is evident from their wear.");

        //Game Opening Text
        System.out.println("\n<<<<o>  Welcome to ZONK  <o>>>>\n");
        System.out.println("You wake up on a train, unaware of where you are or how you got there." + 
        " In your haze, you see a frog in a conductor's outfit scan a keycard up to the train car exit door." +
        " As he exits the car, the keycard falls under a seat. You feel you should start by exploring the carriage you're in and talking to the passengers.\n");
        System.out.println(">> ENTER COMMANDS BELOW: ");

        //Main Game Loop
        while (stillPlaying == true) {
            userResponse = userInput.nextLine().toUpperCase();

            // as the player interacts, you'll check to see if the game should end↓
            if (userResponse.equals("LOOKAROUND")) {
                player.lookAround();
            }

            if (userResponse.equals("EXITLOOP")) {
                stillPlaying = false;
            }

            stillPlaying = false;
        }

        //Testing stuff
        System.out.println("\nI'M TESTING HARDCODED STUFF HERE\n");
        player.talkTo("William");
        player.pickUp("keycard");
        player.nextCar();

        //Close out game
        userInput.close();
    }

}