
/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Game runs the main game
*/
import java.util.Scanner;
import java.util.ArrayList;

public class Game {

  public static void main(String[] args) {
    Train train = new Train();
    Player player = new Player("LAIKA", 3, train);

    //making help function
    for (int i = 0; i < train.cars.length; i++) {
      train.cars[i].methods.add("look around");
      train.cars[i].methods.add("inspect _");
      train.cars[i].methods.add("talk to _");
      train.cars[i].methods.add("pick up _");
      train.cars[i].methods.add("drop _");
      train.cars[i].methods.add("next car");
      train.cars[i].methods.add("check pockets");
      train.cars[i].methods.add("exit game");
      train.cars[i].methods.add("use _");
    } //adds all methods to all cars
    train.cars[1].methods.add("previous car");
    //**WARNING** if u add a new method to car0 or car1 list you must increment this num by 1!!!
    train.cars[2].methods.add("previous car");
    train.cars[2].methods.remove(5); //remove next car method from car2
    train.cars[2].methods.add("exit train");
    train.cars[3].methods.remove(5);
    train.cars[3].methods.add("previous car");
    
    boolean stillPlaying = true;
    Scanner userInput = new Scanner(System.in);
    String userResponse = "";
    ArrayList<String> userResponseSplit = new ArrayList<String>();

    // populate cars with passengers
    train.cars[0].addPassenger("LINDA",
      "Linda has long flowy red hair and a few freckles, and is looking absently out the window.",
      "Hello young man; you look confused. Haha, aren't we all. Why don't you go talk to my son Anton. He's about your age.");
    train.cars[0].addPassenger("WILLIAM", "William has courdouroy pants, a cotton t-shirt, and is smoking a pipe.",
      "My great grandmother told me of a beast that lurks these tracks. You don't believe in such things though, do you?");
    train.cars[0].addPassenger("ANTON", "Anton wears a cozy hoodie with headphones and is reading a book.",
      "I know you want that keycard. Whatever you're up to, I get half, okay?");
    train.cars[2].addPassenger("CONDUCTOR",
      "You notice the conductor is a frog, and a very stylish one at that.\n" +
      " He stands about 5 ft 10 in and wears warm colored overalls with a red cravat and green courdoroy jacket",
      "WE'RE ALL GOING TO DIE!!! THERE'S NO WAY TO DIVERT OUR PATH--THE HUMONGOUS BEAST IS COMPLETELY OBSTRUCTING\n" +
      "THE TRACKS AND I SWEAR I JUST SAW IT LICK ITS LIPS. I can't do anything and everyone is going to perish.\n" +
      "Unless someone jumps the train and baits it away...but nobody would do that--that's absurd.");
    // load items into the cars
    train.cars[0].addItem("KEYCARD", "A thin plastic card. The only parts you can read are \"Lionel...130 Peice\".");
    train.cars[3].addItem("LASER","A big cylindrical item. There is a button on the side of it.");

    // load the player in with a pair of glasses
    player.givePlayer("GLASSES", "Large round spectacles. Carved on the inside are the letters \"LAIKA\".\n" +
        "You don't remember much about who you are or how you got here, but your fondness of these glasses is evident from their wear.");

    // Game Opening Text
    System.out.println("---------------------------------------------------------------------------------------------------");
    System.out.println("|                                 <<<<o>  WELCOME TO ZONK  <o>>>>                                 |");
    System.out.println("---------------------------------------------------------------------------------------------------");
    System.out.println(
      "All is dark. The ground rocks beneath you.\n" +
      " You open your eyes and awake to an old fashioned train full of strange looking passengers.\n" +
      " You remain unaware of where you are or how you got there.\n" +
      " In your haze, you see a frog in a conductor's outfit scan a keycard up to a door.\n" +
      " As he exits the car, the keycard slips from his pocket and falls under a seat.\n" + 
      " \"Hmm maybe I should talk to some of these passengers and explore around a bit.\n" +
      " I really need to get my bearings\", you think to yourself.\n");
    System.out.println(">>TYPE HELP FOR OPTIONS OR ENTER COMMANDS BELOW: ");

    // Main Game Loop
    while (stillPlaying == true) {
      userResponse = userInput.nextLine().toUpperCase();
      if (userResponse.contains("EXIT GAME")
        || userResponse.contains("END GAME")
        || userResponse.contains("QUIT")
        || userResponse.contains("LOOK AROUND")
        || userResponse.contains("TALK TO")
        || userResponse.contains("PICK UP")
        || userResponse.contains("DROP")
        || userResponse.contains("INSPECT")
        || userResponse.contains("NEXTCAR")
        || userResponse.contains("NEXT CAR")
        || userResponse.contains("FORWARD")
        || userResponse.contains("OPEN DOOR")
        || userResponse.contains("PREVIOUSCAR")
        || userResponse.contains("PREVIOUS CAR")
        || userResponse.contains("BACKWARD")
        || userResponse.contains("CHECK POCKETS")
        || userResponse.contains("EXIT TRAIN")
        || userResponse.contains("LEAVE TRAIN")
        || userResponse.contains("JUMP TRAIN")
        || userResponse.contains("HELP")
        || userResponse.contains("USE")) {
        if (userResponse.contains("EXIT GAME") || userResponse.contains("END GAME") || userResponse.contains("QUIT")) {
          System.out.println("You've ended your game of ZONK, I hope you travel with us again!");
          stillPlaying = false;
        }
        if (userResponse.contains("LOOK AROUND")) {
          player.lookAround();
        }
        if (userResponse.contains("TALK TO")) {
          String name = userResponse.split(" ")[2]; //break into words, take the third, all uppercase
          if (!train.cars[player.location].carPassengers.containsKey(name)) { // if name not in carPassengers, print error
            System.out.println("Please enter valid passenger.");
          } else {
            player.talkTo(name);
          }
        }
        if (userResponse.contains("PICK UP")) {
          String name = userResponse.split(" ")[2];
          player.pickUp(name);
        }
        if (userResponse.contains("DROP")) {
          String name = userResponse.split(" ")[1];
          player.drop(name);
        }
        if (userResponse.contains("INSPECT")) {
          String name = userResponse.split(" ")[1];
          player.inspect(name);
        }
        if (userResponse.contains("NEXTCAR") || userResponse.contains("NEXT CAR") || userResponse.contains("FORWARD") || userResponse.contains("OPEN DOOR")) {
          if (player.holding("KEYCARD") && player.metPassengers()) {
            player.nextCar();
          } else {
            System.out.println(
              "The party is still young! Make sure you've fully mingled with the passengers!\n");
          }
        }
        if (userResponse.contains("PREVIOUSCAR") || userResponse.contains("PREVIOUS CAR")
            || userResponse.contains("BACKWARD")) {
          if (player.holding("KEYCARD")) {
            player.previousCar();
          } else {
            System.out.println("You don't have the credentials to move to that car.\n");
          }
        }
        if (userResponse.contains("CHECK POCKETS")) {
          player.checkPockets();
        }
        if (userResponse.contains("EXIT TRAIN") || userResponse.contains("LEAVE TRAIN")
            || userResponse.contains("JUMP TRAIN")) {
          player.exitTrain();
        }
        if (userResponse.contains("HELP")){
          player.help();
        }
        if (userResponse.contains("USE")){
          String obj = userResponse.split(" ")[1];
          if (player.inventory.containsKey(obj)) { 
            player.use(obj);
          } else {
            System.out.println("You do not have object " + obj);
          }
        }
      } else {
        System.out.println("I didn't recognize what you just said there...\n");
      }
    }
    // Close out scanner
    userInput.close();
  }
}