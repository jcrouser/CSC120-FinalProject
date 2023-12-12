/*
 * class that aggregate all menu items
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    public List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    public String getMenuList() {
        StringBuilder menuList = new StringBuilder("Menu Details:\n" + "----------------\n");
        for (MenuItem item : items) {
            menuList.append(item.getMenuItem()).append("\n");
        }
        menuList.append("----------------");
        return menuList.toString();
    }

    public MenuItem getRandomMenuItem() {
        Random random = new Random();
        int index = random.nextInt(items.size());
        return items.get(index);
    }
}
