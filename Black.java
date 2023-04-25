import java.util.Random;
public class Black extends Cat{
    public Black(String name,int dexterity,int strength,int iq, int hp){
        super(name, dexterity, strength, iq, hp);
    }

    public int pointFloor(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        if (randomNumber <= 3){
            return 3;
        }else{
            return randomNumber;
        }
    }
    public int kick(){
        int ttl_dmg = pointFloor() + this.dexterity;
        return ttl_dmg;
    }
    public int bite(){
        int ttl_dmg = pointFloor() + this.strength;
        return ttl_dmg;
    }
    public int escape(){
        int ttl_IQ = pointFloor() + this.iq;
        return ttl_IQ;
    }


    }
