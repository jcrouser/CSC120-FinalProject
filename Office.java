import java.util.Scanner;

public class Office extends Rooms {

    public Office(String name, String description, String objects) {
        super(name, description, objects);
    }

    private static void desk(){
        System.out.println("You have looked into the drawer of the desk but there is nothing there!");
    }

    private static void chair(){
        System.out.println("You have looked under the chair. There are the numbers 1,2,3");
    }

    private static void safe(){
        System.out.println("Enter the passcode to unlock the safe and get the key!");
    }

    private static void door(){
        System.out.println("You need a key to open the door. Open it using the key");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?\n"
        + "1. Look in the drawer of the desk\n"
        + "2. Look under the chair\n"
        + "3. Open the safe\n"
        + "4. open the door\n"
        + "5. Look through inventory\n"
        + "6. get help\n"
        + "7. quit game\n");
        int answer = scan.nextInt();

        while(answer > 6 || answer < 1) {
            System.out.println("pick one of the options");
            answer = scan.nextInt();
        }
        switch(answer) {
            case 1: desk();
                    break;
            case 2: chair();
                    break;
            case 3: safe();
                    break;
            case 4: door();
                    break;
         
        }
        scan.close();

    }


}
