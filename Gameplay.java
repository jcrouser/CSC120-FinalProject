import java.util.Scanner;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Gameplay class represents the game mechanics and logic for playing the game.It includes methods for battling the monster, 
 * keeping track of the player's lives and score, and managing the game flow.
 */

public class Gameplay {

private static Stack<String> previousActions = new Stack<>();
  
  private static int playerLives = 9;
  private static int playerScore = 0;
  public static Monster monster = new Monster("monster", 5, 5, 5);
  public static Cat cat;
  public static int east;
  public static int north;
  public static ArrayList<String> directionalcmd= new ArrayList<String>(Arrays.asList("North", "East", "South", "West", "Northeast", "Northwest", "Southeast", "Southwest"));
  

 
  /**
   * Returns the number of lives the player has remaining.
   * @return an interger representing the number of lives the player has remaining
   */

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
  public static void walk(String direction){
    if (direction ==directionalcmd.get(0)){
        north += 1; 
    }else if (direction ==directionalcmd.get(1)){
        east += 1;
    }else if (direction ==directionalcmd.get(2)){
        north -= 1;
    }else if (direction ==directionalcmd.get(3)){
        east -= 1;
    }else if (direction ==directionalcmd.get(4)){
        north += 1;
        east += 1;
    }else if (direction ==directionalcmd.get(5)){
        north += 1;
        east -= 1;
    }else if (direction ==directionalcmd.get(6)){
        north -= 1;
        east += 1;
    }else if (direction ==directionalcmd.get(7)){
        north -= 1;
        east -= 1;
    }else{
    throw new RuntimeException("I don't understand where to go...");
    }
    }
  public static void battle() {
    System.out.println("A monster has appeared! It's time to battle!");
    System.out.println("What do you want to do?");
    System.out.println("1. Kick");
    System.out.println("2. Escape");
    System.out.println("3. Bite");
    Scanner input4 = new Scanner(System.in);
    String action5 = input4.next();
    monsterencounter(action5);
    previousActions.push(action5);
    System.out.println("do you want to undo");
    String action6 = input4.next();
    if (action6.equalsIgnoreCase("undo")) {
        if (!previousActions.isEmpty()) {
            String lastAction = previousActions.pop();
             // Revert the game state to what it was before the last action was taken
            
        }
       
    // if(lastAction){

    }
    
   
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    Scanner input3 = new Scanner(System.in);

    System.out.println("Welcome to CATaclysm!");
    System.out.println("What is your name");
    String playerName = input.next();
    System.out.println("What cat do you want to be?");
    System.out.println("1. Sunny - Slightly slow but strong");
    System.out.println("2. Yuki - Nimble but tiny");
    System.out.println("3. Babka - Wise but wrinkly");

    System.out.print("Enter the NUMBER of the cat you want to be: ");
    int choice = input.nextInt();
    input.nextLine();

    if (choice == 1) {
      cat = new Cat("Sunny", 5, 7, 3);
      System.out.println("  |\\---/|");
      System.out.println("  | o_o |");
      System.out.println("   \\_^_/");

    } else if (choice == 2) {
      cat = new Cat("Yuki", 7, 5, 5);
      System.out.println(" /\\_/\\");
      System.out.println("( o.o )");
      System.out.println(" > ^ <");

    } else if (choice == 3) {
      cat = new Cat("Babka", 5, 5, 7);
      System.out.println(" /\\_/\\");
      System.out.println("( o o )");
      System.out.println("==_Y_==");
      System.out.println("  `-'");

    } else {
        System.out.println("Unknown input. Please enter a valid number (1, 2, or 3).");
    }
 

    System.out.println("Hi " + cat.toString() + ", you are a member of the colony of magical cats who live underground.");
    input.nextLine();
    // System.out.println("You've been chosen to explore the surface and start a new life. Are you ready?");
    System.out.println("Ever since you were a kitten, you and your litter mates would roam in perpetual darkness. \nThe elder cats would tell tales about how the human nuclear apocalypse forced the colony deep underground. \nThe colony once thrived in a green forest with rushing water, tall trees, and plenty wildlife. \nFor the last few generations, your colony was able to prosper because everyone has their own magical abilities. \nSome cats are super strong, others are very wise. One day you are chosen to find the World Beyond.");

    while (playerLives > 0) {

        if (playerLives == 0){
        System.out.println("You have no lives left. Game over!");
        System.out.println("Your final score is {score}");
        break;}

      System.out.println("You have " + playerLives + " lives left.");
      System.out.println("Your score is " + playerScore);

      System.out.println("You venture out of the underground and explore the ruins of the post-apocalyptic world.");
      System.out.println("What do you want to do next? (explore, hunt, or rest?)");
      String action = input.nextLine();
      // Process player's action
      if (action.equalsIgnoreCase("explore")) {
        // Player chooses to explore the ruins

        
        Scanner input2 = new Scanner(System.in);
        //code for the beginning of the game, the first location
        if (north == 0 && east == 0){
            System.out.println("you are surrounded by other cats, they look at you with eager eyes to learn about your journey. \nTo your south is a path, do you want go south? (Yes/No)");
            String answer1 = input2.next();
            if (answer1.equalsIgnoreCase("Yes")){
                walk("South");
            }else if (answer1.equalsIgnoreCase("No")){
                boolean pass = false; 
                while (pass == false){
                System.out.println("There are nothing more to see here do you want to move forward? (Yes/No)");
                String answer2 = input2.next();
                    if (answer2.equalsIgnoreCase("Yes")){
                        pass = true;
                        walk("South");
                    } else if (answer2.equalsIgnoreCase("No")){
                        pass = false;
                    } else{
                        System.out.println("I don't understand what you are saying...");
                        pass = false;

                    }
                }
            }else{
                System.out.println("I don't understand what you are saying...");
                  boolean pass  = false;
                  while (pass == false){
                    System.out.println("I don't understand where you want to go... Do you want to move forward? (Yes/No)");
                    String answer2_5 = input2.next();
                    if (answer2_5.equalsIgnoreCase("Yes")){
                      walk("South");
                      pass = true;
                    }else if (answer2_5.equalsIgnoreCase("No")){
                        pass = false; 
                        while (pass == false){
                        System.out.println("There are nothing more to see here do you want to move forward? (Yes/No)");
                        String answer2_5_1 = input2.next();
                            if (answer2_5_1.equalsIgnoreCase("Yes")){
                                pass = true;
                                walk("South");
                            } else if (answer2_5_1.equalsIgnoreCase("No")){
                                pass = false;
                            } else{
                                System.out.println("I don't understand what you are saying...");
                                pass = false;
        
                            }
                        }
                    }else{
                      System.out.println("I don't understand where you want to go... Where do you want to go? (East/West/North)");
                      pass = false;
                  }
                }
              }
        // int randomNumber = 75;
        // if (randomNumber <= 10) {
        //   System.out.println("You are lost in the woods. You hear a howling in the distance. The leaves are rustling as wind picks up.");

        }
      
         /**
          * Determines which event occurs based on the random number
          */
        // if (randomNumber <= 25) {
          // 25% chance of finding a treasure
          // System.out.println("You stumble upon a hidden treasure and gain 10 points.");
          // playerScore += 10;
        // } else if (randomNumber <= 50) {
          // 25% chance of encountering a monster
          //here we can throw in the batter mode and call methods from cat and monster class?
          //we are going to have to build cat and monster objects 
          //also we could add a way to keep score through battle wins
          //we could do random again for type of battle/see what method above to call? 
          //we could make a battle mode class?
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

        // } else if (randomNumber <= 75) {
        //   // 25% chance of finding nothing
        //   System.out.println("You find nothing of interest.");
        //   System.out.println("do you want to meow?(Yes,No)");

        //   Scanner input2 = new Scanner(System.in);
        //   String answer1 = input2.next();

        //   if (answer1.equalsIgnoreCase("Yes")||  (answer1.equalsIgnoreCase("yes") )) {
        //     cat.meow();
        //     System.out.println("A monster heard you and approached you quickly");
        //     System.out.println("Do you want to hide or attack?");
        //     String answer4= input3.next();

        //     if (answer4.equalsIgnoreCase("hide")){
        //         cat.hide();
        //     }
            
        // }
         //code if the player goes south 
        if (north == -1 && east == 0){
            System.out.println("you are met with a cross section. Do you want to turn East, West, or go back North?(East/West/North)");
            String answer3 = input2.next();
            if (answer3.equalsIgnoreCase("East")){
                walk("East");
            }else if (answer3.equalsIgnoreCase("West")){
                walk("West");
            }else if (answer3.equalsIgnoreCase("North")){
                walk("North");
            }else{
              boolean pass  = false;
              while (pass == false){
                System.out.println("I don't understand where you want to go... Where do you want to go? (East/West/North)");
                String answer3_5 = input2.next();
                if (answer3_5.equalsIgnoreCase("East")){
                  walk("East");
                  pass = true;
                }else if (answer3_5.equalsIgnoreCase("West")){
                  walk("West");
                  pass = true;
                }else if (answer3_5.equalsIgnoreCase("North")){
                  walk("North");
                  pass = true;
                }else{
                  System.out.println("I don't understand where you want to go... Where do you want to go? (East/West/North)");
                  pass = false;
              }
            
        }
      }
    }
        //code if the player goes west after going south from the main position
        if (north == -1 && east == -1){
          System.out.println("You are encountered with an intersection. To the Southeast there is a dimly lit bunker that is rumored to be haunted. Meanwhile on the Southwest you see a lone cat that seems to have a lot of stories to tell... Where do you choose to go?(Southeast/Southwest/East)");
          String answer4 = input2.next();
          if (answer4.equalsIgnoreCase("Southwest")){
            walk("Southwest");
          }else if (answer4.equalsIgnoreCase("Southeast")){
            walk("Southeast");
          }else if(answer4.equalsIgnoreCase("East")){
            walk("East");
          }else{
            boolean pass1  = false;
            while (pass1 == false){
              System.out.println("I don't understand where you want to go... Where do you want to go? (Southeast/Southwest/East)");
              String answer4_5 = input2.next();
              if (answer4_5.equalsIgnoreCase("Southwest")){
                walk("Southwest");
                pass1 = true;
              }else if (answer4_5.equalsIgnoreCase("Southeast")){
                walk("Southeast");
                pass1 = true;
              }else if(answer4_5.equalsIgnoreCase("East")){
                walk("East");
                pass1 = true;
              }else{
                System.out.println("I don't understand where you want to go... Where do you want to go? (Southeast/Southwest/East)");
                pass1 = false;
              }
            }
          }
        }
        //choice if the player goes east after going south from the original position
        if (north == -1 && east == 1){
          System.out.println("You are encountered with an intersection. To the Southeast there is a passage going forward towards a wall. Meanwhile on the South you see along passage way. Where do you choose to go?(East/Southeast/West)");
          String answer5 = input2.next();
          if (answer5.equalsIgnoreCase("South")){
            walk("South");
          }else if (answer5.equalsIgnoreCase("Southeast")){
            walk("Southeast");
          }else if (answer5.equalsIgnoreCase("West")){
            walk("West");
          }else{
            boolean pass2  = false;
            while (pass2 == false){
              System.out.println("I don't understand where you want to go... Where do you want to go? (East/Southeast/West)");
              String answer5_5 = input2.next();
              if (answer5_5.equalsIgnoreCase("Southeast")){
                walk("Southeast");
                pass2 = true;
              }else if (answer5_5.equalsIgnoreCase("Southwest")){
                walk("Southwest");
                pass2 = true;
              }else if(answer5_5.equalsIgnoreCase("West")){
                walk("West");
                pass2 = true;
              }else{
                System.out.println("I don't understand where you want to go... Where do you want to go? (Southeast/Southwest/West)");
                pass2 = false;
              }
            }
          }
        }
        if (north == -2 && east ==1){
          System.out.println("half way through the passage you saw a door, leading to the dimly lit bunker. Do you want to enter?(Yes/No)");
          String answer8 = input2.next();
          if (answer8.equalsIgnoreCase("Yes")){
            walk("West");
        }else if (answer8.equalsIgnoreCase("No")){
            walk("South");
        }else{
            System.out.println("I don't understand what you are saying...");
              boolean pass  = false;
              while (pass == false){
                System.out.println("I don't understand where you want to go... Do you want to move forward? (Yes/No)");
                String answer2_5 = input2.next();
                if (answer2_5.equalsIgnoreCase("Yes")){
                  walk("West");
                  pass = true;
                }else if (answer2_5.equalsIgnoreCase("No")){
                    pass = false; 
                    while (pass == false){
                    System.out.println("There are nothing more to see here do you want to move forward? (Yes/No)");
                    String answer2_5_1 = input2.next();
                        if (answer2_5_1.equalsIgnoreCase("Yes")){
                            pass = true;
                            walk("South");
                        } else if (answer2_5_1.equalsIgnoreCase("No")){
                            walk("South");
                        } else{
                            System.out.println("I don't understand what you are saying...");
                            pass = false;
    
                        }
                    }
                }else{
                  System.out.println("I don't understand where you want to go... Where do you want to go? (East/West/North)");
                  pass = false;
              }
            }
          }
        }
        if (north == -2 && east == 0){
          System.out.println("In the dimly lit bunker you found a note, it wrote: It has not always been like this... The world has changed beyond recognition. you pondered for a bit, but alas you returned to your senses. To the east there is a passage way leading to a greater passage way. To your Northwest and West there are passages leading to a previous passage ways. Where would you want to go? (East, Northwest, West)");
          String answer7 = input2.next();
          if (answer7.equalsIgnoreCase("East")){
            walk("East");
          }else if (answer7.equalsIgnoreCase("Northwest")){
            walk("Northwest");
          }else if (answer7.equalsIgnoreCase("West")){
            walk("West");
            walk("West");
          }else{
            boolean pass  = false;
            while (pass == false){
              System.out.println("I don't understand where you want to go... Where do you want to go? (East, Northwest, West)");
              String answer5_5 = input2.next();
              if (answer5_5.equalsIgnoreCase("East")){
                walk("East");
                pass = true;
              }else if (answer5_5.equalsIgnoreCase("Northeast")){
                walk("Northeast");
                pass = true;
              }else if (answer5_5.equalsIgnoreCase("West")){
                walk("West");
                walk("West");
                pass = true;
              }else{ 
                System.out.println("I don't understand where you want to go... Where do you want to go? (East, Northwest, West)");
                pass = false;
              }
            }
          }
        }
        //choice if the player goes southeast after going east after going south from the original position
        if (north == -2 && east == -2){
          System.out.println("You met up with the lone cat, he seems to be lost in thought mumbling some thoughts. You approached th elderly cat, he began to talk about something regarding ... the light of the South? You are not quite sure what it is supposed to mean... To your East, there is a dimly lit bunker. Where do you want to go?(East/Northeast)");
          String answer6 = input2.next();
          if (answer6.equalsIgnoreCase("East")){
            walk("East");
            walk("East");
          }else if (answer6.equalsIgnoreCase("Northeast")){
            walk("Northeast");
          }else{
            boolean pass  = false;
            while (pass == false){
              System.out.println("I don't understand where you want to go... Where do you want to go? (East/Northeast)");
              String answer6_5 = input2.next();
              if (answer6_5.equalsIgnoreCase("East")){
                walk("East");
                pass = true;
              }else if (answer6_5.equalsIgnoreCase("Northeast")){
                walk("Northeast");
                pass = true;
              }else{
                System.out.println("I don't understand where you want to go... Where do you want to go? (East/Northeast)");
                pass = false;
              }
            }
          }
        }
        if(north == -2 && east == 2){
          System.out.println("You met a monster!");
          System.out.println("You encounter a monster. Do you want to kick, bite,or escape?");
          String action1 = input.nextLine();
          if (action1.equalsIgnoreCase("kick") || action1.equalsIgnoreCase("bite") || action1.equalsIgnoreCase("escape")){ 
          while(monsterencounter(action1) == false){
          Scanner input5 = new Scanner(System.in);
          System.out.println("Do you want to attack again?");
          String answer_battle1 = input5.next();
          if ( answer_battle1.equalsIgnoreCase("Yes")){
              // String action3 = input5.next();
              monsterencounter(action1);
            } else {
                boolean pass  = false;
                while (pass == false){
                  System.out.println("Do you want to attack again? (Yes/No)");
                  String answer_battle1_5 = input2.next();
                  if (answer_battle1_5.equalsIgnoreCase("Yes")){
                    walk("South");
                    pass = true;
                  }else if (answer_battle1_5.equalsIgnoreCase("No")){
                    walk("Northwest");
                    pass = true;
                  }else{
                    System.out.println("I don't understand where you want to go... Where do you want to go? (East/Northeast)");
                    pass = false;
                  }
                }
              }
            }
          }else{
            boolean pass2 = false;
            while (pass2 == false){
            System.out.println("I don't understand, do you want to kick, bite, or, escape?");
            action1 = input.nextLine();
            while(monsterencounter(action1) == false){
              Scanner input5 = new Scanner(System.in);
              System.out.println("Do you want to attack again?");
              String answer_battle1 = input5.next();
              if ( answer_battle1.equalsIgnoreCase("Yes")){
                  // String action3 = input5.next();
                  monsterencounter(action1);
                } else {
                    boolean pass  = false;
                    while (pass == false){
                      System.out.println("Do you want to attack again? (Yes/No)");
                      String answer_battle1_5 = input2.next();
                      if (answer_battle1_5.equalsIgnoreCase("Yes")){
                        walk("South");
                        pass = true;
                      }else if (answer_battle1_5.equalsIgnoreCase("No")){
                        walk("Northwest");
                        pass = true;
                      }else{
                        System.out.println("I don't understand where you want to go... Where do you want to go? (East/Northeast)");
                        pass = false;
                      }
                    }
                  }
                }
              }
          } 
          System.out.println("You see a passage leading forward, it is another of those bunkers... abandoned and left behind. Do you want to move forward? (Yes/No)");
          String answer9 = input2.next();
          if (answer9.equalsIgnoreCase("Yes")){
            walk("South");
          }else if (answer9.equalsIgnoreCase("No")){
            walk("Northwest");
          }else{
            boolean pass  = false;
            while (pass == false){
              System.out.println("I don't understand where you want to go...do you want to go forward? (Yes/No)");
              String answer6_5 = input2.next();
              if (answer6_5.equalsIgnoreCase("Yes")){
                walk("South");
                pass = true;
              }else if (answer6_5.equalsIgnoreCase("No")){
                walk("Northwest");
                pass = true;
              }else{
                System.out.println("I don't understand where you want to go... Where do you want to go? (East/Northeast)");
                pass = false;
              }
            }
          }
        }if(north == -3 && east == 2){
          System.out.println("You entered the bunker, jumped on top of the shelves in the bunker using your nimble cat feet. On top of the shelves you saw a diary page stating: Oh the Light of the South. How brightly you shine! How warmly you embrace the this crumbling land! you are- /n the page was torn. you swatted the edge of the paper and wondered what the Light of the South means. /n In front of you the bunker door leads you to a passage going straight ahead. Do you want to go forward? (Yes/No)");
          String answer9 = input2.next();
          if (answer9.equalsIgnoreCase("Yes")){
            walk("South");
          }else if (answer9.equalsIgnoreCase("No")){
            walk("Northwest");
          }else{
            boolean pass  = false;
            while (pass == false){
              System.out.println("I don't understand where you want to go... do you want to go forward? (Yes/No)");
              String answer9_5 = input2.next();
              if (answer9_5.equalsIgnoreCase("Yes")){
                walk("South");
                pass = true;
              }else if (answer9_5.equalsIgnoreCase("No")){
                walk("Northwest");
                pass = true;
              }else{
                System.out.println("I don't understand where you want to go... Where do you want to go? (East/Northeast)");
                pass = false;
              }
            }
          }
        }
        if(north == -3 && east == 1){
          System.out.println("To your East is a passage leading to a bunker. Do you want to go East? (East/North)");
          String answer10 = input2.next();
          if (answer10.equalsIgnoreCase("East")){
            walk("East");
          }else if (answer10.equalsIgnoreCase("North")){
            walk("North");
          }else{
            boolean pass  = false;
            while (pass == false){
              System.out.println("I don't understand where you want to go... do you want to go East? (East/North)");
              String answer6_5 = input2.next();
              if (answer6_5.equalsIgnoreCase("East")){
                walk("East");
                pass = true;
              }else if (answer6_5.equalsIgnoreCase("North")){
                walk("North");
                pass = true;
              }else{
                System.out.println("I don't understand where you want to go... Where do you want to go? (East/Northeast)");
                pass = false;
              }
            }
          }
        }
        }

    
        
        if (action.equalsIgnoreCase("hunt")){
            System.out.println("You and your fellow cats set up camp in a burrow hidden by dense vegetation. \nYou decide to set out on a mission to collect goods. \nYou see a smouldering forest to the LEFT and a burnt meadow to the RIGHT.");
            // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber <= 10) {
          System.out.println("You stumble upon a bag of silver coins. \nYou gain 10 points.");
          playerScore += 10;
        }
        if (randomNumber <= 20) {
          System.out.println("You are lost in the woods. n/You hear a howling in the distance. n/The leaves are rustling as wind picks up.");
          int randomNumber2 = random.nextInt(3) + 1; 
          if (randomNumber2 == 1)  {
            System.out.println("You get spooked and you wander even further into the darkness.");
          }             
          }

//        
//         

//     
//         if (randomNumber <= 25) {
//           // 25% chance of finding a treasure
//           System.out.println("You stumble upon a hidden treasure and gain 10 points.");
//           playerScore += 10;
//         } else if (randomNumber <= 50) {
//           // 25% chance of encountering a monster
//           //here we can throw in the batter mode and call methods from cat and monster class?
//           //we are going to have to build cat and monster objects 
//           //also we could add a way to keep score through battle wins
//           //we could do random again for type of battle/see what method above to call? 
//           //we could make a battle mode class?
//           System.out.println("You encounter a monster. Do you want to kick, bite,or escape?");
//           String action1 = input.nextLine();
//           monsterencounter(action1);
//           // System.out.println("Do you want to attack again?");
//           // String answer3 = input3.next();
//           // if ( answer3.equalsIgnoreCase("Yes")){
//           //     String action3 = input3.next();
//           //     monsterencounter(action3);}
//           //     else{
//           //         System.out.print("n");
//           //     }

//         } else if (randomNumber <= 75) {
//           // 25% chance of finding nothing
//           System.out.println("You find nothing of interest.");
//           System.out.println("do you want to meow?(Yes,No)");

//           Scanner input2 = new Scanner(System.in);
//           String answer1 = input2.next();

//           if (answer1.equalsIgnoreCase("Yes")||  (answer1.equalsIgnoreCase("yes") )) {
//             cat.meow();
//             System.out.println("A monster heard you and approached you quickly");
//             System.out.println("Do you want to hide or attack?");
//             String answer4= input3.next();

//             if (answer4.equalsIgnoreCase("hide")){
//                 cat.hide();
//             }
//             else if(answer4.equalsIgnoreCase("attack")){
//                 battle();
//             // System.out.println("Do you want to kick, bite,or escape?");
//             // String action2 = input2.next();
//             // monsterencounter(action2);}

//           } else {
//             System.out.print("I don't understand you!");
//           }

//         } else {
//           // 25% chance of finding a first aid kit
//           System.out.println("You find a first aid kit and gain a life.");
//           if (playerLives < 9) {
//             playerLives += 1;

//           } else {
//             System.out.println("You're fully healthy!");
//           }

//         }
//         // TODO: add more code here to advance the game
//       } else if (action.equalsIgnoreCase("rest")) {
//         if (playerLives < 9) {
//           playerLives += 1;
//           System.out.println("You take a break and rest for a while. You feel refreshed and gain a life.");
//         } else {
//           System.out.println("You already are fully rested.");
//         }
//       } else {
//         // Player enters an invalid action
//         System.out.println("I don't understand what you want to do. Please try again .");
//       }
//     }


//   }
  
  }}}}



