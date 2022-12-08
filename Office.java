import java.util.Scanner;

public class Office extends Rooms{
   
    private String desk;



    public Office (String name, String description, String objects) {
        super(name, description, objects);
 
    }
    
    public void desk(String objects){
        
    }



    
    public static void main(String[] args) { 
        Rooms claRooms = new Rooms("DTI", " white tile floors with white painted walls", "desk");
        System.out.println(claRooms);
        System.out.println("Welcome to the Office!");
        System.out.println("Available options in the Office are: \n + desk \n + filing cabinet \n + desk chair");
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Which would you like to choose?");
            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                if (name == null || name.trim().isEmpty()) {
                    // Error for no input, keeps asking for name 
                    System.out.print("Please put an option shown on the list\n");
                    scan.hasNextLine();
                } else {
                    // Print name
                    System.out.println("You have chosen " + name + "!");
                    break;
                } // End of conditional
            } // End of while loop

      }
}
    
} 
