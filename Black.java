import java.util.Random;
public class Black extends Cat{
    public Black(String name,int dexterity,int strength,int iq, int hp){
        super(name, dexterity, strength, iq, hp);
    }

    public int attackPointFloor(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        if (randomNumber <= 6){
            return 6;
        }else{
            return randomNumber;
        }
    }

    }
