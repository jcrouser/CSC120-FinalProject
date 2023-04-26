import java.util.Random;
public class Monster {
    private String name;
    private int dexterity = 5;
    private int strength = 5;//strength is the number you add onto a attack
    private int iq =5; //iq is intelligence and the ability to block escape, it adds onto a random 0-20 number 
    private int hp = 10; //hp means the total amount of life that you have 
    private Gameplay gameplay;
    public Monster(String name, int strength, int iq, int hp, int dexterity, Gameplay gameplay) {
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.iq = iq;
        this.hp = hp;
        this.gameplay = gameplay;
    }
    
    public int tear() {
        int incomingDmg = getRandomNumber() + strength; //incoming dmg
        return incomingDmg;
    }
    
    public int grabAndThrow() {
        int idmg = getRandomNumber() + dexterity; //incoming dmg
        return idmg;
    }
    
    public int blockEscape() {
        int enemy_IQ = getRandomNumber() + iq;
        return enemy_IQ;
    }
    
    public int blockAttack() {
        int enemy_IQ = getRandomNumber() + iq;
        return enemy_IQ;
    }
    
    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(21);
    }
    
    public String getName() {
        return name;
    }
    
    public int getStrength() {
        return strength;
    }
    
    public int getIntelligence() {
        return iq;
    }
    
    public int getHealthPoints() {
        return hp;
    }
    
    public int getDexterity() {
        return dexterity;
    }
    
    public void reduceHp() {
        if (gameplay.dexBattle() == 1 || gameplay.strengthBattle() == 1) {
            hp--;
        }
    }
}
    
  
