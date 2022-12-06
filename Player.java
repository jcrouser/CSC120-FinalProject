import java.util.ArrayList;

public class Player{
    private String name; //name of the player
    private ArrayList<Clue> inventory = new ArrayList<Clue>(); //player's inventory(where they store clues)
//accessors
    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Clue> getInventory(){
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(ArrayList<Clue> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Clue Item) { // adds clue to inventory when player collects it
        inventory.add(Item);
        System.out.println(Item.getName() + " was added to your inventory.");
    }
    
    public void removeItem(Clue Item) { //removes clue from inventory when player puts it back
        inventory.remove(Item);
        System.out.println(Item.getName() + " was removed from your inventory.");
    }

    public String toString() {
        return this.name + " has" + this.inventory;
    }

    public static void main(String[] args) {
        Player Person = new Player("Jerry");
        System.out.println(Person);
      }
}
