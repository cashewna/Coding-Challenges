import java.util.Scanner;

public class LetsReview {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt(); // number of cases

    /*
     For each case, store each line into a string and convert it into charArrays, on which even
     and odd indexed characters are stored in String even / odd.
    */
    for (int i = 0; i < cases; i++) {
      StringBuilder even;
      StringBuilder odd;
      even = new StringBuilder(odd = new StringBuilder());
      String myString = sc.next();
      char[] charArray = myString.toCharArray();
      // Store even indexed characters to String even
      for (int j = 0; j < charArray.length; j += 2) {
        even.append(charArray[j]);
      }
      // Store odd indexed characters to String odd
      for (int k = 1; k < charArray.length; k += 2) {
        odd.append(charArray[k]);
      }

      // Print String even followed by a space then String odd
      System.out.println(even + " " + odd);
    }
  }
}
