package SocialNetworkProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SocialNetwork extends Graph {
  /**
   * Constructor to create a new graph with n vertices, no edges, and null labels.
   *
   * @param n Number of vertices for this graph object.
   */
  public SocialNetwork(int n) {
    super(n);
  }

  /** Default constructor */
  public SocialNetwork() {
    super();
  }

  /**
   * Adds an edge between two vertices. Edges in social networks are implicitly undirected.
   *
   * @param vertex1 First parameter for two people to make an edge.
   * @param vertex2 Second parameter for two people to make an edge.
   */
  public void addEdge(int vertex1, int vertex2) {
    super.addEdge(vertex1, vertex2, false);
  }

  public void printFriendsList(Graph g, Object label) {
    int[] friends = g.neighbours(g.getVertexIndex(label));
    for (Integer o : friends) {

      System.out.println("- " + g.getLabel(o));
    }
  }

  public void printFriendsAndFriendsOfFriendsList(Graph g, Object label) {
//    printFriendsList(g, label);
    int[] buddies = g.neighbours(g.getVertexIndex(label));
    for (Integer o : buddies) {
      System.out.println("  Friends of " + g.getLabel(o) + ":");

      if (!o.equals(label)) {
        printFriendsList(g, g.getLabel(o));
      }
    }

  }


}
