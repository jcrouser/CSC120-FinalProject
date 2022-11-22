# CSC120-FinalProject
//Right now I'm using this doc as notes and reflection for us. Feel free to put whatever u want here.

Classes we need: Main Game, Passenger, Item, Player, Train, Car

Unofficial interfaces:
    Player Interface: 
        use(Object item) //use means different things for diff objects. still have to figure out how to code this
        move(String direction, int numSpaces) //move forward or backward and add or subtract given number of spaces
        talkTo(Passenger name) //intiate conversation w passenger
        lookAround() //based on location value. tells compiler which cart player is in and describes surroundings
        inspect(Object item) //tells you about item (overloaded)
        inspect(Passenger name) //describes the person (overloaded)

Credit: https://www.codersarts.com/post/java-sample-project-1-text-adventure-game

Maybe helpful resources: https://www.youtube.com/watch?v=j99EeUjvLVQ