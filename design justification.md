## Design Choices and Decisions
I want to design a manage game since I love to play this kind of games. I play *Cooking Fever* and *Good Pizza, Great Pizza* most often and inspired of a google doodle [game](https://doodles.google/doodle/celebrating-bubble-tea/), I decided to set up boba store as context.

The overall sturcture of this game, as stated in `readme.md` and in `cheatsheet.md`, is a manage game for 7 days. 
>During the day the game automatically and randomly generate orders based on opening hour. At the end of the day, the program will check whether player achieves daily income goal, and if yes, the player will have access to manage the store by restocking and extending opening hours. Whenever the game stops, the program will print out a wrap up for the players' game record.

Following the pattern I learned from previous assignments, I created 6 classes in my code: `Store`, `Menu`, `menuItem`, `Inventory`, `gameController`, and `handleInput`. Among all: 
- `menu` has dependency with `menuItem`
- `gameController` has dependencies with `Store`, `Menu`, `Inventory`
- `handleInput` has interactions with `Store`, `Menu`, `Inventory`

Specifically, I added `handleInput` class after first draft of my code. The major reason is that creating multiple scanner object is danger to my code and it frequently fell into error. For instance, I decided to applying merely one scanner throughout the code and aggregate all related codes into one class. After that, I no longer need to import scanner in every class and I am able to use same method for multiple places to avoid petition (e.g., `handleYesNoInput()` method).

## Trade-offs and Alternative Consideration:
I realize that I did not fully take advantage of the associations between classes. For example, having both quantity and price in `Inventory` class does not seem like a good idea. Instead, I can design two subclasses that represents price and quantity respectively that contribute to `Inventory` class. 

Also, I think that I could make the section of taking orders more interesting and engaging. Perhaps, I can ask customers to memorize recipe of menu items and take orders by themselves.

 Since this was my first time creating a project on my own and I was too worried about my coding ability, I was not able to follow all java conventions very well. For exmaple, it is strange to ask for a scanner as input in methods like `setName()`. 
 
 All these shortcomings are due to the fact that I prioritized simplicity over reasonableness when I wrote the code. Nevertheless, I appreciate this exprience and I believe I can do better next time.

## Scalability and Conclusion:
The code demonstrates flexibility to accommodate future enhancements, such as introducing tips, expanding the menu, or adding attributes like cleanliness. Besides, this project serves as a valuable learning experience, laying the foundation for more polished and refined projects in the future.

In conclusion, my design choices aim to deliver an enjoyable gaming experience while providing room for future expansion and improvement. The journey of this project has been really insightful, reinforcing my knowledge in java language and object oriented programming.