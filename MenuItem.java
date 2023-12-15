/*
 * Manages the menu items and their properties
 */
 public class MenuItem {
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
     * @return
     */
    public int getTea() {
        return tea;
    }

    /**
     * @return
     */
    public int getMilk() {
        return milk;
    }

    /**
     * @return
     */
    public boolean isExtraSize() {
        return extraSize;
    }

    /**
     * @return
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
     * getter of name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * constructor
     * @param name
     * @param tea
     * @param milk
     * @param extraSize
     * @param boba
     * @param price
     */
    public MenuItem(String name, int tea, int milk, boolean extraSize, boolean boba, double price){
        this.name = name;
        this.tea = tea;
        this.milk = milk;
        this.extraSize = extraSize;
        this.boba = boba;
        this.price = price;
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

