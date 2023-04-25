import java.util.Random;
public class Cat{
    public static String name;
    public static int dexterity = 5;//dex is the number you add on to a long range attack, which is a random attack number from 0-20, specifically for kick 
    public static int strength = 5;//strength is the number you add onto a attack, specifically for bite 
    public static int iq = 5; //iq is intelligence and the ability to escape, it adds onto a random 0-20 number 
    public static int hp = 9; //hp means the total amount of life that you have 

    public Cat(String name,int dexterity,int strength,int iq, int hp){
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.iq = iq;
        this.hp = 9;

    }

    public void hunt(){
        System.out.println("Hunt");
    }
    public  int kick(){ 
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int ttldmg = randomNumber + this.dexterity;
        return ttldmg;
    }
    public int bite(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int ttldmg = randomNumber + this.strength;
        return ttldmg;
    }
    public int escape(){
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int ttliq = randomNumber + this.iq;
        return ttliq;
    }
    public void scratch(){
        System.out.println("scratch");
    }
    public  void meow(){
        System.out.println("meow");
    }

}