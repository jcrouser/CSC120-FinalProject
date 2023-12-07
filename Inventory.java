// /*
//  * Tracks the restaurant's inventory of ingredients and supplies
//  */

// import java.util.Hashtable;

// public class Inventory {
//     /*
//      * attributes
//      */
//     public int cup;
//     public int tea;
//     public int milk;
//     public int syrup;
//     public int boba;
//     public int cupBuyIn;
//     public int teaBuyIn;
//     public int milkBuyIn;
//     public int syrupBuyIn;
//     public int bobaBuyIn;
//     public int cupSellOut;
//     public int teaSellOut;
//     public int milkSellOut;
//     public int syrupSellOut;
//     public int bobaSellOut;
//     public Hashtable<String, Integer> stockList;

//     /*
//      * constructor that create inventory with default value
//      */
//     public Inventory(){
//         this.cup = 10;
//         this.tea = 10;
//         this.milk = 10;
//         this.syrup = 5;
//         this.boba = 5;
//         this.cupBuyIn = 1;
//         this.teaBuyIn = 1;
//         this.milkBuyIn = 1;
//         this.syrupBuyIn = 1;
//         this.bobaBuyIn = 1;
//         this.cupSellOut = 1;
//         this.teaSellOut = 1;
//         this.milkSellOut = 1;
//         this.syrupSellOut = 1;
//         this.bobaSellOut = 1;
//         this.stockList = new Hashtable<String, Integer>();
//     }

//     /*
//      * accessor of inventory
//      */
//     public Hashtable<String, Integer> getInventory(){
//         this.stockList.put("cup", this.cup);
//         this.stockList.put("tea", this.tea);
//         this.stockList.put("milk", this.milk);
//         this.stockList.put("syrup", this.syrup);
//         this.stockList.put("boba", this.boba);
//         return this.stockList;
//     }

//     /*
//      * method to restock
//      * @param   name    category of inventory
//      * @param   number  number for restock
//      * @return  stockList   updated stockList
//      */
//     public Hashtable<String, Integer> restock(String name, int number){
//         if (stockList.containsKey(name)) {
//             int value = stockList.get(name);
//             this.stockList.put(name, value);
//         }
//         stockList.put("cup", cup);
//         stockList.put("tea", tea);
//         stockList.put("milk", milk);
//         stockList.put("syrup", syrup);
//         stockList.put("boba", boba);
//         return stockList;
//     }
// }
