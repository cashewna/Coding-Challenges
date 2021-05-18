package SocialNetworkProject;

import java.util.*;

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

  /**
   * Prints friends list.
   *
   * @param g Graph object.
   * @param label Name of the person to obtain list from.
   */
  public void printFriendsList(Graph g, Object label) {
    try {
      int[] friends = g.neighbours(g.getVertexIndex(label));
      for (Integer o : friends) {
        System.out.println(g.getLabel(o));
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Either " + label + " does not exist or they have no friends.");
    }
  }

  /**
   * Prints friends and friends of friends of user.
   *
   * @param g Graph object to call from.
   * @param label Name of the person to obtain list from.
   * @exception ArrayIndexOutOfBoundsException Person does not exist or has no friends.
   */
  public void printFriendsAndFriendsOfFriendsList(Graph g, Object label) {
    try {
      g.depthFirstPrint(g, g.getVertexIndex(label));
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Person does not exist or has no friends.");
    }
  }

  /**
   * Prints the mutual friends between two users.
   *
   * @param g Graph object to call from.
   * @param person1 Person A to compare mutual friends with.
   * @param person2 Person B to compare mutual friends with.
   * @exception ArrayIndexOutOfBoundsException Person does not exist or has no mutual friends.
   */
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
      System.out.println("Person does not exist or has no mutual friends.");
    }

    // bothFriends amalgamates all friends from both users
    try {
      for (int i : g.neighbours(vertex2)) {
        bothFriends.add(i);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Person does not exist or has no mutual friends.");
    }

    bothFriends.trimToSize();
    // The use of set removes redundancies and Collections.frequency takes in only friends with a
    // count > 1.
    for (Integer o : bothFriends) {
      if (Collections.frequency(bothFriends, o) > 1) {
        set.add(o);
      }
    }

    for (Integer vertex : set) {
      System.out.println(g.getLabel(vertex));
    }
  }

  /**
   * Deletes user from the social networking program.
   *
   * @param g Graph object to call from.
   * @param person Person to delete from the network.
   */
  public void deletePerson(Graph g, Object person) {
    try {
      int[] friends = g.neighbours(g.getVertexIndex(person));
      int vertexIndex = g.getVertexIndex(person);

      // Removes all edges from user and renames their label to reflect the deletion of user.
      for (int i : friends) {
        removeEdge(vertexIndex, i);
        removeEdge(i, vertexIndex);
        setLabel(vertexIndex, "Deleted User");
      }
    } catch (Exception e) {
      System.out.println("Person does not exist.");
    }
  }

  /**
   * Prints the popularity of users.
   *
   * @param g Graph object to call from.
   */
  public void printPopularity(Graph g) {
    ArrayList<Integer> popularityList = new ArrayList<>(getSize());
    Map<Object, Integer> popularityMap = new HashMap<>(getSize());

    // Add users to ArrayList popularityList.
    for (int i = 0; i < g.getSize(); i++) {
      int[] friends = g.neighbours(i);
      for (Integer o : friends) {
        popularityList.add(o);
      }
    }
    popularityList.trimToSize();

    // Put users in a HashMap and count the frequency of each user's friendships (popularity).
    for (int i : popularityList) {
      popularityMap.put(g.getLabel(i), Collections.frequency(popularityList, i));
    }
    System.out.println();

    /* Sorted popularity map
     false = descending order
     true = ascending order
    */
    Map<Object, Integer> sortedPopularityMap = sortByComparator(popularityMap);
    printMap(sortedPopularityMap);
  }

  /**
   * Print map method to help print popularity list.
   *
   * @param map Map object to print.
   */
  public void printMap(Map<Object, Integer> map) {
    for (Map.Entry<Object, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }

  /**
   * Sorts the map by popularity.
   *
   * @param unsortedMap Map object prior to sorting.
   * @return Returns sortedMap.
   */
  private static Map<Object, Integer> sortByComparator(Map<Object, Integer> unsortedMap) {

    List<Map.Entry<Object, Integer>> list = new LinkedList<>(unsortedMap.entrySet());

    // Sorting the list based on values
    list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    // Maintaining insertion order with the help of LinkedList
    Map<Object, Integer> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<Object, Integer> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }
}
