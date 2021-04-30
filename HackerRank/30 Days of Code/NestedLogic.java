import java.util.Scanner;

/** Day 26 Find out if a book is returned after the due date at a library and calculate the fine. */
public class NestedLogic {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int returnDate = in.nextInt();
    int returnMonth = in.nextInt();
    int returnYear = in.nextInt();

    int dueDate = in.nextInt();
    int dueMonth = in.nextInt();
    int dueYear = in.nextInt();

    if (returnYear > dueYear) {
      System.out.println(10000);
    } else if (returnYear < dueYear) {
      System.out.println(0);
    } else if (returnMonth > dueMonth) {
      System.out.println(500 * (returnMonth - dueMonth));
    } else if (returnDate > dueDate) {
      System.out.println(15 * (returnDate - dueDate));
    } else {
      System.out.println(0);
    }
  }
}
