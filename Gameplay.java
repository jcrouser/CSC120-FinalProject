import java.util.Scanner;
import java.util.Random;

//input needs to be closed

public class Gameplay {
    private Cat cat;
    private Monster monster;

    public Gameplay(Cat cat, Monster monster){
        this.cat = cat;
        this.monster = monster;
    }
    public int strengthBattle(){
        if (cat.bite() > monster.tear()){
            return 1;
        }else if (cat.bite() < monster.tear()){
            return 2;
        }else{
            return 3;
        }
    }
    public int dexBattle(){
        if (cat.kick() > monster.grabAndThrow()){
            return 1;
        }else if (cat.kick() < monster.grabAndThrow()){
            return 2;
        }else{
            return 3;
        }
    }
    public int iqBattle(){
        if (cat.escape() > monster.blockEscape()){
            return 1;
        }else if (cat.escape() < monster.blockEscape()){
            return 2;
        }else{
            return 3;
        }
    }
    public void winLose(){
        if (monster.reduceHp() <= 0){
            System.out.println("Cat win!");
        }else if (cat.resultingHP() <= 0){
            System.out.println("Monster win!");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String playerName;
        int playerLives = 9;
        int playerScore = 0;
        
        System.out.println("Welcome to CATaclysm!");
        //i feel like we could make a selection menu here? it's all in one line. maybe we can add ascii art of cats 
        /*
         *     |\__/,|   (`\
             _.|o o  |_   ) )
            -(((---(((--------
         */
        /*
         *                 /\_/\
                      /\  / o o \
                    / /\\ \~(*)~/
                   `    \/   ^ /
                        | \|| ||
                        \ '|| ||
                         \)()-())
         */
        /*
         *  |\__/,|   (`\
            |_ _  |.--.) )
            ( T   )     /
          (((^_(((/(((_/
         */
        /*
         * 
         * /\_/\  (
          ( ^.^ ) _)
            \"/  (
          ( | | )
         (__d b__)
         */

        System.out.print("What cat do you want to be? You can be Sunny who is slighty slow but strong, Yuki who is nimble but tiny, Cookie who is lucky despite being a black cat, and Babka who is wise but ancient ");
        playerName = input.nextLine();
        System.out.println("Hi " + playerName + ", you are a member of the colony of magical cats who live underground.");
        System.out.println("You've been chosen to explore the surface and start a new life. Are you ready?");

        // Game loop
        while (playerLives > 0) {
            System.out.println("You have " + playerLives + " lives left.");
            System.out.println("Your score is " + playerScore);

            // Prompt for player's next action
            System.out.print("What do you want to do next? (explore or rest) ");
            String action = input.nextLine();
            
            // Process player's action
            if (action.equalsIgnoreCase("explore")) {
                // Player chooses to explore the ruins
                System.out.println("You venture out of the underground and explore the ruins of the post-apocalyptic world.");
                 // Generate a random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;

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
            System.out.println("You encounter a monster and lose a life.");
            playerLives -= 1;
            } else if (randomNumber <= 75) {
            // 25% chance of finding nothing
            System.out.println("You find nothing of interest.");
            } else {
            // 25% chance of finding a first aid kit
            System.out.println("You find a first aid kit and gain a life.");
            playerLives += 1;
            }
                // TODO: add more code here to advance the game
            } else if (action.equalsIgnoreCase("rest")) {
                if (playerLives <9){
                    playerLives += 1; 
                    System.out.println("You take a break and rest for a while. You feel refreshed and gain a life.");
                } else { 
                    System.out.println("You already are fully rested.");
                }
                }
            else {
                // Player enters an invalid action
                System.out.println("I don't understand what you want to do. Please try again.");
            }
        }
        
        // Game over
        System.out.println("You have no lives left. Game over!");
        System.out.println("Your final score is " + playerScore);
    }
    
}

