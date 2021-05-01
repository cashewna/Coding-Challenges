import java.util.Scanner;

/**
 * Day 2: <br>
 * Work with arithmetic operators to solve meal cost + tax + tip percent.
 */
public class Operators {

  // Complete the solve function below.
  static void solve(double meal_cost, int tip_percent, int tax_percent) {
    // Meal cost + tip percent
    double mealTip = meal_cost * (tip_percent / 100.00);

    // Meal cost + tax percent
    double mealTax = meal_cost * (tax_percent / 100.00);

    // Total cost
    double total = meal_cost + mealTip + mealTax;
    int totalInt = (int) Math.round(total);
    System.out.println(totalInt);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    double meal_cost = scanner.nextDouble();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int tip_percent = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int tax_percent = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    solve(meal_cost, tip_percent, tax_percent);

    scanner.close();
  }
}
