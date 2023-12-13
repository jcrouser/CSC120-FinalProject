/*
 * class that aggregate all menu items
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    /*
     * aggregation of objects in menuItem class
     */
    public List<MenuItem> items;

    /**
     * constructor
     */
    public Menu() {
        items = new ArrayList<>();
    }

    /**
     * method that add menuitem to the list
     * @param item
     */
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    /**
     * method that return menu list
     * @return menuList
     */
    public String getMenuList() {
        StringBuilder menuList = new StringBuilder("Menu Details:\n" + "----------------\n");
        for (MenuItem item : items) {
            menuList.append(item.getMenuItem()).append("\n");
        }
        menuList.append("----------------");
        return menuList.toString();
    }

    /**
     * method that randomly generate a menu item
     * @return an object from menuItem
     */
    public MenuItem getRandomMenuItem() {
        Random random = new Random();
        int index = random.nextInt(items.size());
        return items.get(index);
    }
}
