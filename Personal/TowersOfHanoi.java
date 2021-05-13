import java.util.Scanner;

/** Print out each move and the minimum number of moves. */
public class TowersOfHanoi {
  int counter = 0;

  public int getCounter() {
    return counter;
  }

  public void towerOfHanoi(int n, char start, char other, char end) {
    if (n > 0) {
      towerOfHanoi(n - 1, start, end, other);
      counter++;
      System.out.println("Move disk " + n + " from " + start + " to " + end);
      towerOfHanoi(n - 1, other, start, end);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TowersOfHanoi tower1 = new TowersOfHanoi();
    int disks = scanner.nextInt();

    tower1.towerOfHanoi(disks, 'A', 'B', 'C');
    System.out.println("Minimum Moves: " + tower1.getCounter());
  }
}
