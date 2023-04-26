import java.util.Random;
/**

A class representing a monster in a game.
*/
public class Monster {

private String name;
private int dexterity = 5;
private int strength = 5;
private int iq = 5;
private int hp = 10;
private Gameplay gameplay;

/**

Creates a new Monster with the specified name, strength, intelligence, health points, dexterity, and gameplay.
@param name the name of the monster.
@param strength the strength of the monster, which adds onto an attack.
@param iq the intelligence of the monster, which adds onto a random 0-20 number for blocking and escaping.
@param hp the health points of the monster.
@param dexterity the dexterity of the monster, which adds onto an attack.
@param gameplay the Gameplay instance associated with the monster.
*/
public Monster(String name, int strength, int iq, int hp, int dexterity, Gameplay gameplay) {
this.name = name;
this.dexterity = dexterity;
this.strength = strength;
this.iq = iq;
this.hp = hp;
this.gameplay = gameplay;
}
/**

Calculates the incoming damage from a tear attack.
@return the incoming damage from the tear attack.
*/
public int tear() {
int idmg = getRandomNumber() + strength;
return idmg;
}
/**

Calculates the incoming damage from a grab and throw attack.
@return the incoming damage from the grab and throw attack.
*/
public int grabAndThrow() {
int idmg = getRandomNumber() + dexterity;
return idmg;
}
/**

Calculates the enemy's intelligence for blocking and escaping.
@return the enemy's intelligence for blocking and escaping.
*/
public int blockEscape() {
int enemy_IQ = getRandomNumber() + iq;
return enemy_IQ;
}
/**

Calculates the enemy's intelligence for blocking an attack.
@return the enemy's intelligence for blocking an attack.
*/
public int blockAttack() {
int enemy_IQ = getRandomNumber() + iq;
return enemy_IQ;
}
/**

Generates a random number between 0 and 20.
@return the randomly generated number.
*/
private int getRandomNumber() {
Random random = new Random();
return random.nextInt(21);
}
/**

Returns the name of the monster.
@return the name of the monster.
*/
public String getName() {
return name;
}
/**

Returns the strength of the monster.
@return the strength of the monster.
*/
public int getStrength() {
return strength;
}
/**

Returns the intelligence of the monster.
@return the intelligence of the monster.
*/
public int getIntelligence() {
return iq;
}
/**

Returns the health points of the monster.
@return the health points of the monster.
*/
public int getHealthPoints() {
return hp;
}
/**

Returns the dexterity of the monster.
@return the dexterity of the monster.
*/
public int getDexterity() {
return dexterity;
}
 
public void reduceHp() {
    if (gameplay.dexBattle() == 1 || gameplay.strengthBattle() == 1) {
        hp--;
    }
}
}
    
  
