import java.util.Scanner;

/**
 * Day 19
 */
public class Interfaces {
    interface AdvancedArithmetic{
        int divisorSum(int n);
    }

    // We only have to add common denominators up till n/2 + n itself to sum
    static class Calculator implements AdvancedArithmetic {
        public int divisorSum(int n) {
            int sum = 0;
            for(int i = 1; i <= n/2; i++) {
                if(n % i == 0) {
                    sum += i;
                }
            }
            sum += n;
            return sum;
        }
    }

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.close();

    AdvancedArithmetic myCalculator = new Calculator();
    int sum = myCalculator.divisorSum(n);
    System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
    System.out.println(sum);
    }
}
