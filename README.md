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




Stuff to do:

    <<done>>-fill out description of cars in player lookAround() method. car 1 is populated with passengers, is kinda nice looking, car two is empty like for storage and kinda decrepid. Car three is   almost at the front of the train. Dont know what vibe it should be giving off. you should notice a door that leads outside in this car though.
    <<fixed>>-lookAround should have a condition for if youre outside the cabin. maybe then location=3. might have to update next car also, idk yet.
    <<fixed>>-fix bug with lookAround() where the else statements always gets called in addition to the correct if statement

    -getPassenger doesnt work--prints out memory address
    <<fixed>>-can call nextCar from the locomotive car...made exittrain its own thing so it doesnt get dealt with in next car
    -when picking somehting up remove from car's item list? checking if we need card to get previous cars--cuz if you drop it then it reverts location, that would suck. then when drop, add to current car's list ALSO do we need to update look around to show relocated items??
    -end condition. what you see as you are outside the cabin. cat and stuff.
    <<done>>-cant analyze anthing. install inspect()
    <<done>>cant leave train
    -when a passenger isnt in the same car, it still says please enter valid passenger. do something about it or not?
    -Drop item (into same car that ur in)
    -user laser
    <<done>>-meet conductor
    -prompt with the end choice (go from there)
    -java doc
    <<done>>check if this drop() and new pickUp() feature works (should remove from carItems and place in inventory and vice versa)
    <<fixed>>Car class seems to have extra indentation
    -<<done>>The help list based on location doesn't seem to be working, and check pockets doesn't show up for some reason? 
    -<<done>>Add use (and more) to help
    -when no space between command words, dropkeycard error thrown and stops the game. I think I should make an if for if the user input doesnt have a next in the split
    -right now u have to pocket the giant laser to use it. maybe we make a custom function for it and instead use the use() method for other items we put around the train. they could either be fun easter eggs or we could make winning the game harder by adding more tasks. like maybe there's some obstacle in the second car

    
    Stretch goals:
    -if u remove cat passener diologues update
    -general use function
    -more items/things to do
    -ASCII art train drawing in intro



  **IM NOW PUTTING MY COMMIT HISTORY HERE SINCE WE DONT NEED VSCODE ANYMORE**
  -Janna: made help() based on location, updated and formatted story, made ZONK banner



  Test Feedback:

  -need to tell player that help is location based
  -crash game by inspecting nothing
  -use keycard should do nextCar
  -if u type inspect with nothing it should give u a list of things that u can inspect