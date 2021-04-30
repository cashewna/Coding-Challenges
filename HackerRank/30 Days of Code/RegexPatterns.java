import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day 28 Given N rows of data, print an alphabetically-ordered list of people (firstNames) whose
 * email address ends in @gmail.com
 */
public class RegexPatterns {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int N = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String gmailRegex = "(@gmail.com)";
    Pattern p = Pattern.compile(gmailRegex);
    ArrayList<String> sort = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] firstName_email = scanner.nextLine().split(" ");
      String firstName = firstName_email[0];
      String email = firstName_email[1];

      Matcher m = p.matcher(email);
      while (m.find()) {
        sort.add(firstName);
      }
    }
    scanner.close();

    Collections.sort(sort);

    for (String s : sort) {
      System.out.println(s);
    }
  }
}
