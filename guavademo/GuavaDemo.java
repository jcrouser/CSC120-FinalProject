package guavademo;

import com.google.common.graph.*;

public class GuavaDemo {
  public static void main(String[] args) {

    // Example ImmutableGraph with Strings as Node data
    ImmutableGraph<String> myGraph = GraphBuilder.undirected()
      .<String>immutable()
      .putEdge("Bass", "McConnell")
      .putEdge("McConnell", "Sabin-Reed")
      .putEdge("Sabin-Reed", "Burton")
      .build();

    //System.out.println(myGraph);

    // Example ImmutableGraph with Buildings as Node data
  Building bass = new Building("Ball Hall", "4 Tyler Ct");
  Building mcConnell = new Building("McConnell Hall", "2 Tyler Ct");
  Building burton = new Building("Burton Hall", "46 College Ln");
  Building sabinReed = new Building("Sabin-Reed Hall", "44 College Ln");
  
    ImmutableGraph<Building> myGraph2 = GraphBuilder.undirected()
      .<Building>immutable()
      .putEdge(bass, mcConnell)
      .putEdge(mcConnell, sabinReed)
      .putEdge(sabinReed, burton)
      .build();

      System.out.println(myGraph2);
  }

}