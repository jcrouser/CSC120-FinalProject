import java.util.Random;
public class Monster {
    public static String name;
    public static int dexterity = 5;
    public static int strength = 5;//strength is the number you add onto a attack
    public static int iq =5; //iq is intelligence and the ability to block escape, it adds onto a random 0-20 number 
    public static int hp = 10; //hp means the total amount of life that you have 
    public static Gameplay gameplay;
    public Monster(String name,int strength,int iq, int hp, int dexterity, Gameplay gameplay){
        this.name = name;
        this.dexterity = dexterity;
        this.strength=strength;
        this.iq=iq;
        this.hp=hp;
        this.gameplay = gameplay;
    }
    public int tear(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int idmg = randomNumber + this.strength; //incoming dmg
        return idmg;
    }
    public int grabAndThrow(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int idmg = randomNumber + this.dexterity; //incoming dmg
        return idmg;
    }
    public int blockEscape(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int enemy_IQ = randomNumber + this.iq;
        return enemy_IQ;
    }
    public int blockAttack(){
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
    public int getDexterity(){
        return this.dexterity;
    }
    public int resultingHP(){
        if (gameplay.dexBattle() ==1 || gameplay.strengthBattle() ==1 || gameplay.iqBattle() == 1){
            this.hp =- 1;
            return this.hp;
        }else{
            this.hp = this.hp;
            return this.hp;
        }
    }
}
