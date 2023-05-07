import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
/**

The Cat class represents a cat in the game.
*/
public class Cat{
    public String name;
    private int dexterity ;//dex is the number you add on to a long range attack, which is a random attack number from 0-20, specifically for kick 
    private int strength ;//strength is the number you add onto a attack, specifically for bite 
    private int iq ; //iq is intelligence and the ability to escape, it adds onto a random 0-20 number 
  
    public static Gameplay gameplay;
    public int east = 0;
    public int north = 0;
    public ArrayList<String> directionalcmd =new ArrayList<String>(Arrays.asList("North", "East", "South", "West"));
    /**
    * Constructor for the Cat class.
    * @param name The name of the cat.
    * @param dexterity The dexterity of the cat.
    * @param strength The strength of the cat.
    * @param iq The intelligence of the cat.
    * @param hp The hit points of the cat.
    * @param gameplay The gameplay object that the cat interacts with.
    */
    public Cat(String name,int dexterity,int strength,int iq){
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.iq = iq;
        
    }
    /**
    * we don't know yet.
    */
    public void hunt(){
        System.out.println("Hunt");
    }

    /**
    * The cat kicks
    * @return The total damage dealt by the cat's kick.
    */
    public int kick(){ 
        Random random = new Random();
        int randomNumber = random.nextInt(dexterity); 
        int ttl_dmg = randomNumber + this.dexterity;
        return ttl_dmg;
    }
    /**
     * The cat bites.
    * @return The total damage dealt by the cat's bite.
    */
    public int bite(){
        Random random = new Random();
        int randomNumber = random.nextInt(strength); 
        int ttl_dmg = randomNumber + this.strength;
        return ttl_dmg;
    }
    /**
    * The cat tries to escape.
    * @return The total IQ of the cat and a random number from 0-20.
    */
    public int escape(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int ttl_IQ = randomNumber + this.iq;
        return ttl_IQ;
    }
    public void hide(){
        System.out.println("The monster can't see you now");
    }
    public  void meow(){
        System.out.println("meow! meow! meow!");
    }
    public  void purr(){
        System.out.println("The cats collectively purrs");
    }
    /**
    * Gets the name of the cat.
    * @return The name of the cat.
    */
    public String getName(){
        return name;
    }
    /**
    * Gets the dexterity of the cat.
    * @return The dexterity of the cat.
    */
    public int getDexterity(){
        return this.dexterity;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getIQ(){
        return this.iq;
    }
   

    
    
    

        
}