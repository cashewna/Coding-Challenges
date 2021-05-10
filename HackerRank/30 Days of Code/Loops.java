import java.util.Scanner;

/**
 * Day 5: Loops <br>
 * Given an integer, print its first 10 multiples. Each multiple should be printed on a newline.
 */
public class Loops {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    int answer; // initialise answer
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 1; i <= 10; ++i) {
      answer = n * i;
      System.out.println(n + " x " + i + " = " + answer);
    }
    scanner.close();
  }
}
