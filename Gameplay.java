import java.util.Scanner;
import java.util.Random;
import java.util.Stack;

/**
 * The Gameplay class represents the game mechanics and logic for playing the game.It includes methods for battling the monster, 
 * keeping track of the player's lives and score, and managing the game flow.
 */

public class Gameplay {

private static Stack<String> previousActions = new Stack<>();
  private static int playerLives = 9;
  private static int playerScore = 0;
  public static Monster monster = new Monster("monster", 5, 5, 5);
  private static Cat cat;

  public int getPlayerlives() {
    return playerLives;
  }

  /**
   * Returns the player's current score
   * @return an interger representing the player's current score
   */

  public int getPlayerScore() {
    return playerScore;
  }

  /**
   * Simulates a battle between a cat and a monster based on their respective strength attributes.
   * @return an integer value of the outcome based on the winner of the battle:
   * <ul>
   *     <li>1 if the cat's bite strength is greater than the monster's tear strength</li>
   *     <li>2 if the monster's tear strength is greater than the cat's bite strength</li>
   * </ul>
   */

  public static int strengthBattle() {
    if (cat.bite() > monster.tear()) {
      return 1;
    } else {
      return 2;
    }
  }

  /**
   * Simulates a battle between a cat and a monster based on their respective dexterity attributes.
   * @return an integer value of the outcome based on the winner of the battle:
   * <ul>
   *     <li>1 if the cat's kick dexterity is greater than the monster's grab and throw dexterity</li>
   *     <li>2 if the monster's grab and throw dexterity is greater than the cat's kick dexterity/li>
   * </ul>
   */

  public static int dexBattle() {
    if (cat.kick() > monster.grabAndThrow()) {
      return 1;
    } else {
      return 2;
    }
  }
  /**
   * Simulates a battle between a cat and a monster based on their respective IQ attributes.
   * @return an integer value of the outcome based on the winner of the battle:
   * <ul>
   *     <li>1 if the cat's escape IQ is greater than the monster's block IQ</li>
   *     <li>2 if the monster's block IQ and throw dexterity is greater than the cat's kick dexterity/li>
   * </ul>
   */

  public static int iqBattle() {
    if (cat.escape() > monster.blockEscape()) {
      return 1;
    } else {
      return 2;
    }
  }

  /**
   * Determines the winner of a battle between a cat and a monster based on their respective dexterity attributes,
   * and outputs the result to the console.
   * 
   * If the cat wins, the method prints "Your attack was stronger than the monster. Cat wins!"
   * If the monster wins, the method prints "The monster was stronger than you. Monster wins!" and decrements the player's life count.
   */

  public static boolean winLoseDex() {
    if (dexBattle() == 1) {
      System.out.println("Your attack was stronger than the monster.");
      System.out.println("Cat wins!");
      return true;
    } else {
      System.out.println("The monster was stronger than you.");
      System.out.println("Monster wins!");
      playerLives--;
      return false;
    }
  }

  /**
   * Determines the winner of a battle between a cat and a monster based on their respective strength attributes,
   * and outputs the result to the console.
   * 
   * If the cat wins, the method prints "You are strong enough to win. Cat wins!"
   * If the monster wins, the method prints "You are not strong enough to win. Monster wins!" and decrements the player's life count.
   */

  public static boolean winLoseStrength() {
    if (strengthBattle() == 1) {
      System.out.println("You are strong enough to win.");
      System.out.println("Cat wins!");
      return true;
    } else {
      System.out.println("You are not strong enough to win.");
      System.out.println("Monster wins!");
      playerLives--;
      return false;
      
    }
  }

  /**
   * Determines the winner of a battle between a cat and a monster based on their respective IQ attributes,
   * and outputs the result to the console.
   * 
   * If the cat wins, the method prints "You are smart enough to escape. Cat wins!"
   * If the monster wins, the method prints "You are not smart enough to escape. Monster wins!" and decrements the player's life count.
   * 
   * @return  The current count of the player's remaining lives after the battle.
   */

  public static boolean winLoseIq() {
    if (iqBattle() == 1) {
      System.out.println("you are smart enough to escape");
      System.out.println("Cat wins!");
      return true;
    } else{
      System.out.println("you are not smart enough to escape");
      System.out.println("Monster wins!");
      playerLives--;
      return false;
    }
  }

  /**
   * Simulates a battle encounter between a player's cat and a monster, where the player chooses an action to perform against the monster.
   * The method checks the validity of the player's chosen action and calls the appropriate winLose method based on the action chosen.
   * If the player enters an invalid action, the method prints an error message and does not perform any action.
   *
   * @param action1 The player's chosen action to perform against the monster.
   */

  public static boolean monsterencounter(String action1) {
    if (action1.equalsIgnoreCase("kick")) {
      return winLoseDex();
    } else if (action1.equalsIgnoreCase("escape")) {
      return winLoseIq();
    } else if (action1.equalsIgnoreCase("bite")) {
      return winLoseStrength();
    } else {
      // Player enters an invalid action
      System.out.println("I don't understand what you want to do. Please try again.");
      return false;

    }

  /**
   * Simulates a battle encounter between a player's cat and a monster. The method prompts the player to choose an action to perform against the monster, 
   * checks the validity of the player's chosen action, and calls the appropriate winLose method based on the action chosen.
   * The method also allows the player to undo their previous action by entering "undo", and keeps track of the player's previous actions using a Stack.
   * 
   */
    
  }
  public static void battle() {
    System.out.println("A monster has appeared! It's time to battle!");
    boolean pass1 = true;
    while (pass1 == true){
    System.out.println("What do you want to do?");
    System.out.println("1. Kick");
    System.out.println("2. Escape");
    System.out.println("3. Bite");
    Scanner input4 = new Scanner(System.in);
    String action5 = input4.next();
    // monsterencounter(action5);
    previousActions.push(action5);
    if (monsterencounter(action5) ==false){
      boolean pass = true;
      while (pass == true){
    System.out.println("do you want to undo");
    String action6 = input4.next();
    if (action6.equalsIgnoreCase("undo")||  (action6.equalsIgnoreCase("yes"))) {
        if (!previousActions.isEmpty()) {
            String lastAction = previousActions.pop();
            playerLives++;
            pass = false;
             // Revert the game state to what it was before the last action was taken
             System.out.println("Undoing action: " + lastAction);
             // Implement the necessary logic to revert the game state
         } else {
             System.out.println("No actions to undo.");
             pass = true;
         }
        pass1 = true;
        }else if (action6.equalsIgnoreCase("No")){
          pass = false;
          pass1 = false;
        }
    }
        }else{
          pass1 = false;
        }
  }
       
    // if(lastAction){

    }
    
   
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    Scanner input3 = new Scanner(System.in);

    System.out.println("Welcome to CATaclysm!");
    // System.out.println("What is your name");
    // String playerName = input.next();
    System.out.println("What cat do you want to be?");
    System.out.println("1. Sunny - Slightly slow but strong");
    System.out.println("2. Yuki - Nimble but tiny");
    System.out.println("3. Babka - Wise but wrinkly");

    //  prompts user enter the number of the cat that they wanr to be
    System.out.print("Enter the NUMBER of the cat you want to be: ");

    //reads user's choice
    int choice = input.nextInt();
    input.nextLine();

    //  Assign a new Cat object to 'cat' based on the user's choice
    if (choice == 1) {
      // Create a new Cat object with the name "Sunny" and the attributes (5, 7, 3)
      cat = new Cat("Sunny", 5, 7, 3);
      //  Print out a cat ascii art
      System.out.println("  |\\---/|");
      System.out.println("  | o_o |");
      System.out.println("   \\_^_/");

    } else if (choice == 2) {
      //  Create a new Cat object with the name "Yuki" and the attributes (7, 5, 5)
      cat = new Cat("Yuki", 7, 5, 5);
      //  Print out a cat ascii art
      System.out.println(" /\\_/\\");
      System.out.println("( o.o )");
      System.out.println(" > ^ <");
      
    } else if (choice == 3) {
      //  Create a new Cat object with the name "Babka" and the attributes (5, 5, 7)
      cat = new Cat("Babka", 5, 5, 7);
      //  Print out a cat ascii art
      System.out.println(" /\\_/\\");
      System.out.println("( o o )");
      System.out.println("==_Y_==");
      System.out.println("  `-'");

    } else {
      // Print an error message if the user enters anything else
        System.out.println("Unknown input. Please enter a valid number (1, 2, or 3).");
    }
 
    // Prints a welcome message to the user, addressing the chosen cat by its name.
    System.out.println("Hi " + cat.toString() + ", you are a member of the colony of magical cats who live underground.");
    // Reads the user's input without using it, effectively waiting for the user to press Enter.
    input.nextLine();
    // Asks the user if they are ready to start the game.
    System.out.println("You've been chosen to explore the surface and start a new life. Are you ready?");

    while (playerLives > 0) {

        if (playerLives == 0){
        System.out.println("You have no lives left. Game over!");
        System.out.println("Your final score is {score}");
        break;}

      System.out.println("You have " + playerLives + " lives left.");
      System.out.println("Your score is " + playerScore);

      // Prompt for player's next action

      System.out.print("What do you want to do next? (explore or rest)");
      String action = input.nextLine();

      // Process player's action
      if (action.equalsIgnoreCase("explore")) {
        // Player chooses to explore the ruins
        System.out.println("You venture out of the underground and explore the ruins of the post-apocalyptic world.");
        // Generate a random number between 1 and 100
        // int randomNumber = random.nextInt(100) + 1;
        int randomNumber = 50;
        if (randomNumber <= 10) {
          System.out.println("You are lost in the woods. You hear a howling in the distance. The leaves are rustling as wind picks up.");

        }
        // Determine which event occurs based on the random number
        if (randomNumber <= 25) {
          // 25% chance of finding a treasure
          System.out.println("You stumble upon a hidden treasure and gain 10 points.");
          playerScore += 10;
        } else if (randomNumber <= 50) {
          // 25% chance of encountering a monster
          //here we can throw in the batter mode and call methods from cat and monster class?
          //we are going to have to build cat and monster objects 
          //also we could add a way to keep score through battle wins
          //we could do random again for type of battle/see what method above to call? 
          //we could make a battle mode class?
          battle();
          // System.out.println("You encounter a monster. Do you want to kick, bite,or escape?");
          // String action1 = input.nextLine();
          // monsterencounter(action1);
          // System.out.println("Do you want to attack again?");
          // String answer3 = input3.next();
          // if ( answer3.equalsIgnoreCase("Yes")){
          //     String action3 = input3.next();
          //     monsterencounter(action3);}
          //     else{
          //         System.out.print("n");
          //     }

        } else if (randomNumber <= 75) {
          // 25% chance of finding nothing
          System.out.println("You find nothing of interest.");
          System.out.println("do you want to meow?(Yes,No)");

          Scanner input2 = new Scanner(System.in);
          String answer1 = input2.next();

          if (answer1.equalsIgnoreCase("Yes")||  (answer1.equalsIgnoreCase("yes") )) {
            cat.meow();
            System.out.println("A monster heard you and approached you quickly");
            System.out.println("Do you want to hide or attack?");
            String answer4= input3.next();

            if (answer4.equalsIgnoreCase("hide")){
                cat.hide();
            }
            else if(answer4.equalsIgnoreCase("attack")){
                battle();
            System.out.println("Do you want to kick, bite,or escape?");
            String action2 = input2.next();
            monsterencounter(action2);}

          } else {
            System.out.print("I don't understand you!");
          }

        } else {
          // 25% chance of finding a first aid kit
          System.out.println("You find a first aid kit and gain a life.");
          if (playerLives < 9) {
            playerLives += 1;

          } else {
            System.out.println("You're fully healthy!");
          }

        }
        
      } else if (action.equalsIgnoreCase("rest")) {
        if (playerLives < 9) {
          playerLives += 1;
          System.out.println("You take a break and rest for a while. You feel refreshed and gain a life.");
        } else {
          System.out.println("You already are fully rested.");
        }
      } else {
        // Player enters an invalid action
        System.out.println("I don't understand what you want to do. Please try again .");
      }
    }


  }
  
  }

