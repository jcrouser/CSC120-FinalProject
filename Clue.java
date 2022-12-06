public class Clue {
    private String name; //name of the object
    private String description; //How it looks like
    private int amount; //How many of the object is in the room

    public Clue(int amount, String name, String description) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }
//accessors
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public int getamount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString() {
        return "There is " + this.amount + " " + this.name + " and it looks like " + this.description;
    }

    public static void main(String[] args) {
        Clue code = new Clue(1, "desk", "a stained brown desk with golden knobs on the drawers");
        System.out.println(code);
      }
}
