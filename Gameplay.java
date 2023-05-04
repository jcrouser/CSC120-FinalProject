import java.util.Scanner;
import java.util.Random;

//input needs to be closed

public class Gameplay {

    public static int playerLives = 9;
    public static int playerScore = 0;
    public static Cat cat = new Cat("Sunny", 5, 5, 5, 1);
    public static Monster monster = new Monster("Hala", 5, 5, 1, 5);

 
    public static int strengthBattle(){
        if (cat.bite() > monster.tear()){
            return 1;
        }
        else{
            return 2;}
        }
    
    public static int dexBattle(){
        if (cat.kick() > monster.grabAndThrow()){
           
            return 1;
            
        }
        else {
            return 2;
           
        }
      
    }

    public static int iqBattle() {
        if (cat.escape() > monster.blockEscape()) {
            return 1;
        } else {
            return 2;
        }
    }

    
        public static void winLoseDex() {
            if (dexBattle() == 1) {
                System.out.println("Your attack was stronger than the monster.");
                System.out.println("Cat wins!");
            } else {
                System.out.println("The monster was stronger than you.");
                System.out.println("Monster wins!");
                playerLives--;
            }
        }
    
        
    public static void winLoseStrength() {
        if (strengthBattle() == 1) {
            System.out.println("You are strong enough to win.");
            System.out.println("Cat wins!");
        } else {
            System.out.println("You are not strong enough to win.");
            System.out.println("Monster wins!");
            playerLives--;
        }
    }
            public static int winLoseIq(){
                if ( iqBattle()==1) {
                    System.out.println("you are smart enough to escape");
                    System.out.println("Cat wins!");
                    return playerLives;
                }
                else if( iqBattle()==2){
                    System.out.println("you are not smart enough to escape");
                    System.out.println("Monster wins!");
                     playerLives--;}
                    return playerLives;
                }
            public static void monsterencounter(String action1){
            if (action1.equalsIgnoreCase("kick")) {
            winLoseDex();
                }
             else if ( action1.equalsIgnoreCase("escape")){
                    winLoseIq();
                }
             else if ( action1.equalsIgnoreCase("bite")){
                    winLoseStrength();
                }
            else{
                // Player enters an invalid action
                System.out.println("I don't understand what you want to do. Please try again.");

            }
            }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        
        // int playerLives = 9;
        // int playerScore = 0;
        
        System.out.println("Welcome to CATaclysm!");
        System.out.println("What is your name");
        String playerName =input.next();   
        System.out.println("What cat do you want to be?");
        System.out.println("1. Sunny - Slightly slow but strong");
        System.out.println("2. Yuki - Nimble but tiny");
        System.out.println("3. Babka - Wise but wrinkly");

        System.out.print("Enter the number of the cat you want to be: ");
        int choice = input.nextInt();
        Cat sunny;
        Cat Yuki;
        Cat Bapka;
        if (choice==1){
         sunny = new Cat("Sunny", 5, 7, 3, 1);
        }
        else  if (choice==2){
         Yuki = new Cat("Yuki", 7, 5, 5, 1);
            }
        else  if (choice==3){
          Bapka = new Cat("Bapka", 5, 5, 7, 1);
                }
        
        
        System.out.println("Hi " + playerName + ", you are a member of the colony of magical cats who live underground.");
        input.nextLine();
        System.out.println("You've been chosen to explore the surface and start a new life. Are you ready?");
    

    
        // Game loop
        while (playerLives > 0) { 
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
            int randomNumber =75;

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
            monsterencounter(action1);


            } else if (randomNumber <= 75) {
            // 25% chance of finding nothing
            System.out.println("You find nothing of interest.");
            System.out.println("do you want to meow?(Yes,No)");

            
            Scanner input2 = new Scanner(System.in);
            String answer1= input2.next();
           
            if ( answer1.equalsIgnoreCase("Yes")){
                
                cat.meow();
                System.out.println("A monster heard you and approached you quickly");
                System.out.println("Do you want to kick, bite,or escape?");
                String action2 = input2.next();
                monsterencounter(action2);}
            else{
                System.out.print("n");
            }


            } else {
            // 25% chance of finding a first aid kit
            System.out.println("You find a first aid kit and gain a life.");
            if (playerLives < 9){
            playerLives += 1;

            } else {
                System.out.println("You're fully healthy!");
            }
            
            }
                // TODO: add more code here to advance the game
            } 
            else if (action.equalsIgnoreCase("rest")) {
                if (playerLives <9){
                    playerLives += 1; 
                    System.out.println("You take a break and rest for a while. You feel refreshed and gain a life.");
                } else { 
                    System.out.println("You already are fully rested.");
                }
                }

            else {
                // Player enters an invalid action
                System.out.println("I don't understand what you want to do. Please try again .");
            }
        }
        
        // Game over
        System.out.println("You have no lives left. Game over! ");
        System.out.println("Your final score is " + playerScore);
    }
    
}

