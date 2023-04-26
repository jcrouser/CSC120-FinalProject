import java.util.Random;

public class Grey extends Cat {

    public Grey(String name, int dexterity, int strength, int iq, int hp, Gameplay gameplay) {
        super("Bobca", dexterity, 3, 7, hp, gameplay);
    }

    // You can add any additional methods or variables specific to the GreyCat class here
public static void main(String[] args) {
    Grey myGreyCat = new Grey(name, dexterity, strength, iq, hp, gameplay);
}
}