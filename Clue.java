public class Clue {
    private String name; //name of the object
    private String description; //How it looks like
    private int amount; //How many of the object is in the room

    public Clue(String name, String description, int amount) {
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
}

