package guavademo;
public class Building {

    String name;
    String address;
  
    public Building(String name, String address) {
      this.name = name;
      this.address = address;
    }
  
    public String toString() {
      return name + " (" + address + ")";
    }
    
  }