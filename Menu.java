// /*
//  * Manages the menu items and their properties
//  */

// import java.util.Random;
// import java.util.Hashtable;

// public class Menu {
//     /*
//      * attributes
//      */
//     public int tea;
//     public int milk;
//     public boolean extraSize;
//     public boolean boba;
//     public int price;
//     public Hashtable<Integer, Menu> menuList;

//     public Menu(int tea, int milk, boolean extraSize, boolean boba, int price){
//         this.tea = tea;
//         this.milk = milk;
//         this.extraSize = extraSize;
//         this.boba = boba;
//         this.price = price;
//     }

//     public Hashtable<Integer, Menu> updateMenuList(Menu menu){
//         int index = menuList.size() + 1;
//         menuList.put(index, menu);
//         return menuList;
//     }

//     public Hashtable<Integer, Menu> getMenuList(){
//         return menuList;
//     }

//     public Menu getRandomMenu(){
//         Random random = new Random();
//         int randomIndex = random.nextInt(menuList.size());
//         return menuList.get(randomIndex);
//     }

//     Menu smallMilkTea = new Menu(2, 1, false, false, 4);
//     Menu largeMilkTea = new Menu(2, 1, true, false, 5);
//     Menu smallBobaMilkTea = new Menu(1, 1, false, true, 6);
//     Menu largeBobaMilkTea = new Menu(1, 1, true, true, 7);    
// }
