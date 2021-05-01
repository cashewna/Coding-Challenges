import java.util.Scanner;

/**
 * Day 1: <br>
 * Add int variables, double variables, and concatenate Strings
 */

public class DataTypes {

  public static void main(String[] args) {
    int i = 4;
    double d = 4.0;
    String s = "HackerRank ";

    Scanner scan = new Scanner(System.in);

    /* Declare second integer, double, and String variables. */
    int v1;
    double v2;
    String v3;

    v1 = scan.nextInt();
    v2 = scan.nextDouble();
    scan.nextLine(); // read the rest of newline input (blank)
    v3 = scan.nextLine();

    /* Print the sum of both integer variables on a new line. */
    System.out.println(i + v1);
    System.out.println(d + v2);
    System.out.println(s + v3);

    scan.close();
  }
}
