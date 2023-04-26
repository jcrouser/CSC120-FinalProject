import java.util.Random;

public class Cat {
    private String name;
    private int dexterity;
    private int strength;
    private int iq;
    private int hp;

    public Cat(String name, int dexterity, int strength, int iq, int hp) {
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.iq = iq;
        this.hp = hp;
    }

    public void hunt() {
        System.out.println("Hunt");
    }

    public int kick(Cat target) {
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int ttl_dmg = randomNumber + this.dexterity;
        target.setHP(target.getHP() - ttl_dmg);
        return ttl_dmg;
    }

    public int bite(Cat target) {
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int ttl_dmg = randomNumber + this.strength;
        target.setHP(target.getHP() - ttl_dmg);
        return ttl_dmg;
    }

    public int escape(Cat target) {
        Random random = new Random();
        int randomNumber = random.nextInt(21); 
        int ttl_IQ = randomNumber + this.iq;
        if (ttl_IQ > target.getIQ()) {
            System.out.println("You successfully escaped!");
        } else {
            System.out.println("You failed to escape.");
        }
        return ttl_IQ;
    }

    public void scratch() {
        System.out.println("The cats collectively scratches on the rug");
    }

    public void talk(String message) {
        System.out.println(message);
    }

    public String getName() {
        return this.name;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getIQ() {
        return this.iq;
    }

    public int getHP() {
        return this.hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void updateHP(int damage) {
        this.hp -= damage;
    }
}
