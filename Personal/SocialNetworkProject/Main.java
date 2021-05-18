package SocialNetworkProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    int k; // Menu switch
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

    do {
    showMenu();
    k = sc.nextInt();
      sc.nextLine();
      switch (k) {
        case 1 -> {
          System.out.println("Enter name of friend:");
          String case1_input = sc.nextLine();
          g.setUser1(case1_input);
          System.out.println(case1_input + "'s friends and friends of friends:");
          g.printFriendsAndFriendsOfFriendsList(g, case1_input);
        }
        case 2 -> {
          System.out.println("Enter name of friend:");
          String case2_input = sc.nextLine();
          System.out.println(case2_input + "'s friends:");
          g.printFriendsList(g, case2_input);
        }
        case 3 -> {
          System.out.println("Choose two users:");
          String case3_input = sc.nextLine();
          String case3_input2 = sc.nextLine();
          System.out.println(
                  "Mutual friends between " + case3_input + " and " + case3_input2 + ":");
          g.printMutualFriends(g, case3_input, case3_input2);
        }
        case 4 -> {
          System.out.println("Enter person to delete from the network:");
          String case4_input = sc.nextLine();
          System.out.println("Are you sure about that? y/n");
          String case4_input2 = sc.nextLine();
          if (case4_input2.equals("y")) {
            g.deletePerson(g, case4_input);
          } else {
            System.out.println("Returning to main menu...");
          }
        }
        case 5 -> {
          System.out.println("Listing all members by popularity...");
          g.printPopularity(g);
        }
        case 6 -> System.out.println("Thank you for using this program. Goodbye!");
      }
    } while (k != 6);
  }

  public static void showMenu() {
    System.out.println(
            """
                    1. List friends of the selected user and friends of friends.
                    2. List friends of the selected user.
                    3. List mutual friends between two users.
                    4. Delete a member from the network.
                    5. List all members sorted by popularity and names.
                    6. Exit.""");
  }
}
