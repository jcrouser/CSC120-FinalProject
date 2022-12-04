import java.util.Scanner;

public class EscapeRoom {
    public static void main(String[] args) {
        //Opening prompt for escape room
            System.out.println("Welcome to the Escape Room!");
                    System.out.println("""
                    There will be three rooms the bedroom, office, and bathroom. 
                    You can start in any room but in order to go from one room to another you need to find a key in each room to unlock the door.
                    There will clues in the room your in to find the key.""");
                    //Ask player for name
                    try (Scanner scan = new Scanner(System.in)) {
                        System.out.println("What is your name?");
                        while (scan.hasNextLine()) {
                            String name = scan.nextLine();
                            if (name == null || name.trim().isEmpty()) {
                                // Error for no input, keeps asking for name 
                                System.out.print("Please, what is your name?\n");
                                scan.hasNextLine();
                            } else {
                                // Print name
                                System.out.println("Welcome to the Escape Room " + name + " Good luck" + " !");
                                break;
                            } // End of conditional
                        } // End of while loop
                    }
    }
}
