/*
 * Manages the menu items and their properties
 */
 public class menuItem {
    /*
     * attributes
     */
    private String name;
    private int tea;
    private int milk;
    private boolean extraSize;
    private boolean boba;
    private double price;

    /**
     * constructor
     * @param name
     * @param tea
     * @param milk
     * @param extraSize
     * @param boba
     * @param price
     */
    public menuItem(String name, int tea, int milk, boolean extraSize, boolean boba, double price){
        this.name = name;
        this.tea = tea;
        this.milk = milk;
        this.extraSize = extraSize;
        this.boba = boba;
        this.price = price;
    }
    
    /**
     * getter of name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method that return inventory of tea
     * @return tea
     */
    public int getTea() {
        return tea;
    }

    /**
     * method that return inventory of milk
     * @return milk
     */
    public int getMilk() {
        return milk;
    }

    /**
     * method that returns boolean value for extra size
     * @return extraSize
     */
    public boolean isExtraSize() {
        return extraSize;
    }

    /**
     * method that returns boolean value for boba
     * @return boba
     */
    public boolean isBoba() {
        return boba;
    }
    
    /**
     * getter of price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * method that return single menu item
     * @return menu description
     */
    public String getMenuItem() {
        return "Name: " + name +
        "\tTea: " + tea + 
        "\tMilk: " + milk + 
        "\tExtra Size: " + extraSize +
        "\tBoba: " + boba +
        "\tPrice: " + price;
    }
}

