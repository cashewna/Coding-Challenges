import java.util.Scanner;

/**
 * Day 3: <br>
 * If n is odd print Weird. <br>
 * If n is even and in the inclusive range of 6 to 20 print Weird. <br>
 * If n is even and greater than 20 print Not Weird. <br>
 * .
 */
public class ConditionalStatementsIntro {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int N = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // Ternary operator
    final String msg = N % 2 != 0 || (6 <= N && N <= 20) ? "Weird" : "Not Weird";

    System.out.println(msg);

    scanner.close();
  }
}
