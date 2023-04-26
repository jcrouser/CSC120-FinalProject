import java.util.Random;
public class Black extends Cat{
<<<<<<< HEAD
    public Black(String name,int dexterity,int strength,int iq, int hp){
        super("Joe", dexterity, strength, iq, hp);
=======
    public Black(String name,int dexterity,int strength,int iq, int hp, Gameplay gameplay){
        super(name, dexterity, strength, iq, hp, gameplay);
>>>>>>> f32fb133a2f0ed12b22895cf76b1d0f9a4ee55ac
    }

    public int leastPoint(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        if (randomNumber <= 3){
            return 3;
        }else{
            return randomNumber;
        }
    }
    public int kick(){
        int ttl_dmg = leastPoint() + this.dexterity;
        return ttl_dmg;
    }
    public int bite(){
        int ttl_dmg = leastPoint() + this.strength;
        return ttl_dmg;
    }
    public int escape(){
        int ttl_IQ = leastPoint() + this.iq;
        return ttl_IQ;
    }


    }
