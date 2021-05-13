import java.util.Scanner;

/** Print out each move and the minimum number of moves. */
public class TowerOfHanoi {
  int counter = 0;

  public int getCounter() {
    return counter;
  }

  public void towerOfHanoi(int disks, char source, char aux, char destination) {
    if (disks > 0) {
      towerOfHanoi(disks - 1, source, destination, aux);
      counter++;
      System.out.println("Move disk " + disks + " from " + source + " to " + destination);
      towerOfHanoi(disks - 1, aux, source, destination);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TowerOfHanoi tower1 = new TowerOfHanoi();
    int disks = scanner.nextInt();

    tower1.towerOfHanoi(disks, 'A', 'B', 'C');
    System.out.println("Minimum Moves: " + tower1.getCounter());
  }
}
