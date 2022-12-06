import java.util.ArrayList;
import java.util.Hashtable;

public class Cart {

    private Hashtable<Product, Number> items;
    private double total;

    public Cart(){
        items = new Hashtable<Product, Number>();
        total = 0;
    }

    public void addToCart(Product item, int amount){
        while(amount>0){
            items.add(item);
            amount--;
        }
    }

    public double getTotal(){
        for(Product item : items){
            total += item.getPrice();
        }
        return total;
    }
}
