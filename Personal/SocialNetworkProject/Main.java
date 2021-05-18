package SocialNetworkProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    int graphSize;
    String friendFileName;
    String indexFileName;
    SocialNetwork g = new SocialNetwork();

    System.out.print("Enter index filename: ");
    indexFileName = sc.nextLine();
    System.out.print("Enter friend filename: ");
    friendFileName = sc.nextLine();

    // Process indexFileName.txt
    // Catch FileNotFound
    try {
      Scanner indexFile =
          new Scanner(new File("Personal/test/resources/" + indexFileName + ".txt"));

      graphSize = indexFile.nextInt();
      indexFile.nextLine();
      g = new SocialNetwork(graphSize);
      for (int i = 0; i < graphSize; i++) {
        indexFile.nextInt();
        g.setLabel(i, indexFile.next());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Index file \"" + indexFileName + ".txt\" not found. Please try again.");
    }

    // Process friendFileName.txt
    // Catch FileNotFound
    try {
      Scanner friendFile =
          new Scanner(new File("Personal/test/resources/" + friendFileName + ".txt"));
      int n = friendFile.nextInt(); // Number of friend pairs.
      for (int i = 0; i < n; i++) {
        g.addEdge(friendFile.nextInt(), friendFile.nextInt());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Friend file \"" + friendFileName + ".txt\" not found. Please try again.");
    }

    // Test Code Here
    System.out.println("Size: " + g.getSize());
    System.out.println("Label at 0: " + g.getLabel(0));
    System.out.println("Label at 1: " + g.getLabel(1));
    System.out.println("Label at 2: " + g.getLabel(2));
    System.out.println("Label at 3: " + g.getLabel(3));
    System.out.println("Get vertex index \"Wallace\": " + g.getVertexIndex("Wallace"));
    System.out.println("Wallace's Friend List: ");
    g.printFriendsList(g, "Wallace");
    System.out.println("Batman's Friends and Friends of Friends List: ");
    g.setUser1("Batman");
    g.printFriendsAndFriendsOfFriendsList(g, "Batman");
    System.out.println("Mutual friends: ");
    g.printMutualFriends(g, "Wallace", "Gromit");
    g.deletePerson(g, "Wallace");
    System.out.println("Label at 0: " + g.getLabel(0));
    System.out.println("Label at 1: " + g.getLabel(1));
    System.out.println("Label at 2: " + g.getLabel(2));
    System.out.println("Label at 3: " + g.getLabel(3));
    System.out.println("Label at 4: " + g.getLabel(4));
    System.out.println("Label at 5: " + g.getLabel(5));
    g.printFriendsList(g, "Wallace");
  }
}
