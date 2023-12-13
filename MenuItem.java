/*
 * Manages the menu items and their properties
 */
 public class MenuItem {
    /*
     * attributes
     */
    public String name;
    public int tea;
    public int milk;
    public boolean extraSize;
    public boolean boba;
    public double price;

    public MenuItem(String name, int tea, int milk, boolean extraSize, boolean boba, double price){
        this.name = name;
        this.tea = tea;
        this.milk = milk;
        this.extraSize = extraSize;
        this.boba = boba;
        this.price = price;
    }

    public String getMenuItem() {
        return "Name: " + name +
        "\t Tea: " + tea + 
        "\tMilk: " + milk + 
        "\tExtra Size: " + extraSize +
        "\tBoba: " + boba +
        "\tPrice: " + price;
    }
}

