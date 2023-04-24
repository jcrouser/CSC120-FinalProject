import java.util.Random;
public class Cat{
    public static int dexterity;//dex is the number you add on to a long range attack, which is a random attack number from 0-20, specifically for kick 
    public static int strength;//strength is the number you add onto a attack, specifically for bite 
    public static int iq; //iq is intelligence and the ability to escape, it adds onto a random 0-20 number 
    public static int hp; //hp means the total amount of life that you have 

    public Cat(int dexterity,int strength,int iq, int hp){
        this.dexterity=dexterity;
        this.strength=strength;
        this.iq=iq;
        this.hp=9;

    }

    public void hunt(){
        System.out.println("Hunt");
    }
    public  void kick(){
        System.out.println("kick");
    }
    public void bite(){
        System.out.println("bite");
    }
    public void scratch(){
        System.out.println("scratch");
    }
    public  void meow(){
        System.out.println("meow");
    }

}