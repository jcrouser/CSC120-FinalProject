import java.util.ArrayList;
import java.util.Arrays;
public class Location {
    public int east;
    public int north;
    public ArrayList<String> directions;
    public ArrayList<String> directionscmd= new ArrayList<String>(Arrays.asList("North", "East", "South", "West"));
    public Gameplay gameplay 

    public Location(int east, int north){
        this.east = east;
        this.north = north;
        this.directions= new ArrayList<String>();
    }
    
    

}
