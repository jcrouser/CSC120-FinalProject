public class Rooms {
    private String name;
    private String objects;
    private String description;

    public Rooms(String name, String description, String objects) {
        this.name = name;
        this.description = description;
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getobjects() {
        return objects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setAmount(String objects) {
        this.objects = objects;
    }
    public String toString() {
        return this.name + " is a room with" + this.description + ". In this room there is a " + this.objects + ".";
    }

    public static void main(String[] args) {
        Rooms claRooms = new Rooms("DTI", " white tile floors with white painted walls", "desk");
        System.out.println(claRooms);
      }
}
