public class Product{

    private int aisle;
    private String name;
    private double price;
    private boolean byEach;


    public Product(int aisle, String name, double price, boolean byEach){
        this.aisle = aisle;
        this.name = name;
        this.price = price;
        this.byEach = byEach;

    }

    public int getAisle(){
        return aisle;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public boolean getType(){
        return byEach;
    }

}