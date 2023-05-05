import java.util.Random;
    /**
    
    The Monster class represents a monster in a game. Each monster has a name, strength, intelligence, health points, and dexterity.
    
    The Monster class contains methods for attacking and defending, as well as for reducing the monster's health points.
    */
    public class Monster {
    private String name; // The name of the monster
    private int dexterity = 5; // The dexterity of the monster
    private int strength = 5; // The strength of the monster; added onto attack damage
    private int iq = 5; // The intelligence of the monster; added onto defense
    private Gameplay gameplay; // The gameplay object that the monster is a part of
    
    /**
    
    *Creates a new Monster object with the specified name, strength, intelligence, health points, dexterity, and gameplay object.
    *@param name the name of the monster
    *@param strength the strength of the monster
    *@param iq the intelligence of the monster
    *@param hp the health points of the monster
    *@param dexterity the dexterity of the monster
    *@param gameplay the gameplay object that the monster is a part of
    */
    public Monster(String name, int strength, int iq, int dexterity) {
    this.name = name;
    this.dexterity = dexterity;
    this.strength = strength;
    this.iq = iq;

    }
    /**
    
    *Calculates the damage done by a tear attack and returns it.
    *@return the amount of damage done by the tear attack
    */
    public int tear() {
    int incomingDmg = getRandomNumber() + strength;
    return incomingDmg;
    }
    /**
    
    *Calculates the damage done by a grab and throw attack and returns it.
    *@return the amount of damage done by the grab and throw attack
    */
    public int grabAndThrow() {
    int idmg = getRandomNumber() + dexterity;
    return idmg;
    }
    /**

    *Calculates the enemy's intelligence for blocking and escaping.
    *@return the enemy's intelligence for blocking and escaping.
    */
    public int blockEscape() {
        int enemy_IQ = getRandomNumber() + iq;
        return enemy_IQ;
    }
    
    /**
    
    *Returns a random number between 0 and 20.
    *@return a random number between 0 and 20
    */
    private int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(21);
    }
    /**
    
    *Returns the name of the monster.
    *@return the name of the monster
    */
    public String getName() {
    return name;
    }
    /**
    
    *Returns the strength of the monster.
    *@return the strength of the monster
    */
    public int getStrength() {
    return strength;
    }
    /**
    
    *Returns the intelligence of the monster.
    *@return the intelligence of the monster
    */
    public int getIntelligence() {
    return iq;
    }
    /**
    
//     *Returns the health points of the monster.
//     *@return the health points of the monster
//     */
//     public int getHealthPoints() {
//         return hp;
//     }

   /**
    * Returns the dexterity level of the monster.
    *
    * @return the dexterity level of the monster
    */
    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    /**
    * Reduces the health points of the monster by 1 if the attack is successful.
    * An attack is successful if the gameplay's dexBattle() or strengthBattle() method returns 1.
    */
 

    // public void setStrength(int strength) {
    //     this.strength = strength;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setIntelligence(int iq) {
    //     this.iq = iq;
    // }

    // public void setHealthPoints(int hp) {
    //     this.hp = hp;
    // }
    


    
}

    
  
