import java.util.Scanner;
import java.util.Random;

public class chatbot {
    private Scanner input;
    private Random random;
    private Cat cat;
    private Monster monster;
    private int playerLives;
    private int playerScore;
    private boolean isGameOver;

    public chatbot() {
        input = new Scanner(System.in);
        random = new Random();
        playerLives = 9;
        playerScore = 0;
        isGameOver = false;
    }

    public void start() {}
}
