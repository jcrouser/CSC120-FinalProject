public class Cat{
    public String name;
    public int dexterity;
    public int strength;
    public int iq;
    public int hp; 

    public Cat(String name,int dexterity,int strength,int iq, int hp){
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