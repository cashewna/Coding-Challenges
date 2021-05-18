package SocialNetworkProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
    try {
      int[] friends = g.neighbours(g.getVertexIndex(label));
      for (Integer o : friends) {
        System.out.println("- " + g.getLabel(o));
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.print("No friends.");
    }
  }

  public void printFriendsAndFriendsOfFriendsList(Graph g, Object label) {
    g.depthFirstPrint(g, g.getVertexIndex(label));
  }

  public void printMutualFriends(Graph g, Object person1, Object person2) {
    ArrayList<Integer> bothFriends = new ArrayList<>(g.getSize());
    Set<Integer> set = new HashSet<>();
    int vertex1 = g.getVertexIndex(person1);
    int vertex2 = g.getVertexIndex(person2);
    try {
      for (int i : g.neighbours(vertex1)) {
        bothFriends.add(i);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("No mutual friends.");
    }

    try {
      for (int i : g.neighbours(vertex2)) {
        bothFriends.add(i);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("No mutual friends.");
    }

    bothFriends.trimToSize();
    for (Integer o : bothFriends) {
      if (Collections.frequency(bothFriends, o) > 1) {
        set.add(o);
      }
    }

    for (Integer vertex : set) {
      System.out.println(g.getLabel(vertex));
    }
  }

  public void deletePerson(Graph g, Object person) {
    try {
      int[] friends = g.neighbours(g.getVertexIndex(person));
      int vertexIndex = g.getVertexIndex(person);
      for (int i : friends) {
        removeEdge(vertexIndex, i);
        removeEdge(i, vertexIndex);
        setLabel(vertexIndex, "Deleted User");
      }
    } catch (Exception e) {
      System.out.println("Person does not exist.");
    }
  }

  public void printPopularity(Graph g) {
    //
  }
}
