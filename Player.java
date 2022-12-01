import java.util.Hashtable;

public class Player {
    public String name;
    public boolean belief;
    public double hauntChance;
    public Hashtable<Boolean, String> inventory;

    public Player(String name, boolean belief) {
        this.name = name;
        this.belief = belief;
        this.hauntChance = 1000.00;
        this.inventory = new Hashtable<Boolean, String>();

    }

    public double changeChance(double newChance) {// changes the hauntChance
        this.hauntChance = newChance;
        return this.hauntChance;
    }

    public void addInventory(Boolean evidence, String object) {// adds obejcts or evidence to player's inventory
        this.inventory.put(evidence, object);
    }
}
