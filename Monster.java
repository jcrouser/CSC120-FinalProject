import java.util.Random;
public class Monster {
    public static String name;
    public static int strength = 5;//strength is the number you add onto a attack
    public static int iq =5; //iq is intelligence and the ability to block escape, it adds onto a random 0-20 number 
    public static int hp = 10; //hp means the total amount of life that you have 
    public Monster(String name,int strength,int iq, int hp){
        this.name = name;
        this.strength=strength;
        this.iq=iq;
        this.hp=hp;
    }
    public int tear(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int idmg = randomNumber + this.strength; //incoming dmg
        return idmg;
    }
    public int blockEscape(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int enemy_IQ = randomNumber + this.iq;
        return enemy_IQ;
    }
    public String getName() {
        return this.name;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getIQ(){
        return this.iq;
    }
    public int getHP(){
        return this.hp;
    }
}
