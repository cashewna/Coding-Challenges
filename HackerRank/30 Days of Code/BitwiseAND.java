import java.util.Scanner;

/**
 * Day 29: <br>
 * Given a set of numbers of 2 through N, find the result of two integers in the set such that A & B
 * <= K where K is a given integer.
 */
class Result {

  /**
   * Example, if N = 5 and K = 2. <br>
   * 1 | 2 = 3 which is less or equal to N. Thus the result is 1. A & B has to be less than K so we
   * do not need to check the entire set, giving us time complexity O(1).
   */
  public static int bitwiseAnd(int N, int K) {
    if (((K - 1) | K) <= N) {
      return (K - 1);
    }
    return (K - 2);
  }
}

public class BitwiseAND {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt(); // Number of test cases
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int k = in.nextInt();
      int result = Result.bitwiseAnd(n, k);
      System.out.println(result);
    }
  }
}
