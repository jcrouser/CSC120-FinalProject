# SPOILER ALERT
This file will contain documentation for all commands available in my game.

## Available Commands
### `Store` Class
- Store(String name)
- getName()
- getBalance()
- getOpeningTime()
- setName(Scanner in)
- setBalance(double balance)
- setOpeningTime(int openingTime)
- extendOpeningTime(Store store, Scanner in)
- getStoreInfo()

### `Menu` Class
- Menu()
- addMenuItem(MenuItem item)
- getMenuList()
- getRandomMenuItem()

### `MenuItem` Class
- MenuItem(String name, int tea, int milk, boolean extraSize, boolean boba, double price)
- getName()
- getTea()
- getMilk()
- isExtraSize()
- isBoba()
- getPrice()
- getMenuItem()

### `Inventory` Class
- Inventory()
- getCup()
- getTea()
- getMilk()
- getBoba()
- getCupBuyIn()
- getTeaBuyIn()
- getMilkBuyIn()
- getBobaBuyIn()
- setCup(int cup)
- setTea(int tea) 
- setMilk(int milk)
- setBoba(int boba)
- getInventoryList()
- restockCost(String itemType, int quantity)
- restock(Store store, String input, int number, Scanner in)

### `gameController` Class
- helpPage(Store store, Menu menu, Inventory inventory, Scanner in)
- description()
- dailyOrder(Store store, Menu menu, Inventory inventory, Hashtable<Integer, String> dailyReceipt)
- orderAvailability(Inventory inventory, menuItem order)
- orderAvailabilityIdentifier(menuItem order, Inventory inventory)
- updateInventory(Inventory inventory, menuItem order)
- getReceipt(Integer day, Hashtable<Integer, String> dailyReceipt, double dailyIncome)
- manageTab(Inventory inventory, Menu menu, Store store, double dailyIncome, Scanner in)
- getTotalReceipt(Hashtable<Integer, Double> totalReceipt)
- finalResult(Store store, Inventory inventory, Hashtable<Integer, Double> totalReceipt)

### `handleInput` Class
- handleResetNameInput(Store store, Scanner in)
- handleHelpPageInput(Store store, Menu menu, Inventory inventory, Scanner in, Boolean loop)
- handleManageInput(Store store, Menu menu, Inventory inventory, Scanner in, Boolean loop)
- handleRestockInput(Store store, Inventory inventory, Scanner in)
- handleRestockNumberInput(String message, Scanner in)
- handleExtendHourInput(Store store, Scanner in)
- handleYesNoInput(Scanner in)

## Description Of The Layout
The game is about running a boba store for 7 days. During the day the game automatically and randomly generate orders based on opening hour. At the end of the day, the program will check whether player achieves daily income goal, and if yes, the player will have access to manage the store by restocking and extending opening hours. Whenever the game stops, the program will print out a wrap up for the players' game record.

## Challenges
To keep surviving, the main challenge is to earn as much money as possible and strategically spend it on updating your store.
- **Restock** ensures that your store is able to take all orders in stead of refund. For a business that is just starting out and therefore in desperate need of money, any refund could be fatal!
- As players move into the later stages of the game, the guaranteed inventory per order is not enough to meet the rapidly growing income goals, thus it is worth considering to **Extend Opening Hours**. However, considering how to divide the funds becomes a new dilemma.

