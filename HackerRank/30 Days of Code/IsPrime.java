import java.util.Scanner;

public class IsPrime {

  // Faster algorithm vs first submission as it uses square root of n

  static boolean isPrime(int n) {
    double numSqrt = Math.sqrt(n);

    if (numSqrt == 1) {
      return false;
    }

    for (int i = 2; i <= numSqrt; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    // Store each case into an array of size t
    int[] cases = new int[t];
    for (int i = 0; i < t; i++) {
      cases[i] = in.nextInt();
    }

    for (int num : cases) {
      if (isPrime(num)) {
        System.out.println("Prime");
      } else {
        System.out.println("Not prime");
      }
    }
  }
}
