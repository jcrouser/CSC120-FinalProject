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
        String playerName = " ";
        int playerLives = 9;
        int playerScore = 0;
        
        System.out.println("Welcome to CATaclysm!");

        System.out.println("What cat do you want to be?");
        System.out.println("1. Sunny - Slightly slow but strong");
        System.out.println("2. Yuki - Nimble but tiny");
        System.out.println("3. Cookie - Lucky despite being a black cat");
        System.out.println("4. Babka - Wise but wrinkly");

        System.out.print("Enter the number of the cat you want to be: ");
        int choice = input.nextInt();

        
        
        // switch (choice) {
        //     case 1:
        //         System.out.println("You have chosen Sunny.");
        //         System.out.println("  |\\__/,|   (`\\");
        //         System.out.println("  |_ _  |.--.) )");
        //         System.out.println("  ( T   )     /");
        //         System.out.println(" (((^_(((/(((_/");
        //         playerName = "Sunny";
        //         // sunny = new Orange(playerName, 5, 10, 8, 100, null);             
        //         break;
        //     case 2:
        //         System.out.println("You have chosen Yuki.");
        //         System.out.println("/\\_/\\  (");
        //         System.out.println("( ^ .^ ) _)");
        //         System.out.println(" \\\"\\  (");
        //         System.out.println("( | | )");
        //         System.out.println("( d b )");
        //         playerName = "Yuki";
        //         White yuki = new White(playerName, 8, 3, 5, 100, null);

        //         break;
        //     case 3:
        //         System.out.println("You have chosen Cookie.");
        //         System.out.println("     |\\__/,|   (`\\");
        //         System.out.println("   _.|o o   |_   ) )");
        //         System.out.println("   -(((---(((--------");
        //         playerName = "Cookie";
        //         Black cookie = new Black(playerName, choice, playerLives, playerScore, choice, null);

        //         break;
        //     case 4:
        //         System.out.println("You have chosen Babka.");
        //         System.out.println(" *                     /\\_/\\");
        //         System.out.println("                  /\\  / o o \\");
        //         System.out.println("                / /\\\\ \\~(*)~/");
        //         System.out.println("               `    \\/   ^ /");
        //         System.out.println("                    | \\|| ||");
        //         System.out.println("                    \\ '|| ||");
        //         System.out.println("                     \\)()-())");
        //         playerName = "Babka";
        //         Grey babka = new Grey (playerName, 2, 3, 7, 100, null);
        //         break;
        //     default:
        //         System.out.println("Invalid choice.");
        //         break;
        // }

        
        System.out.println("Hi " + playerName + ", you are a member of the colony of magical cats who live underground.");
        input.nextLine();
        System.out.println("You've been chosen to explore the surface and start a new life. Are you ready?");

        // Game loop
        while (playerLives > 0) {
           Orange sunny = new Orange(playerName, 5, 10, 8, 100, null); 
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
            //we could make a battle mode class?
            System.out.println("You encounter a monster. Do you want to kick, bite,or escape?");
            String action1 = input.nextLine();
            if (action1.equalsIgnoreCase("kick")) {
               sunny.kick();


                }

            playerLives -= 1;
            } else if (randomNumber <= 75) {
            // 25% chance of finding nothing
            System.out.println("You find nothing of interest.");
            } else {
            // 25% chance of finding a first aid kit
            System.out.println("You find a first aid kit and gain a life.");
            if (playerLives < 9){
            playerLives += 1;

            } else {
                System.out.println("You're fully healthy so you give it to a friend.");
            }
            
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

