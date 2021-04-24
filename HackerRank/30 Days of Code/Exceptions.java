import java.util.Scanner;

/**
 * Day 16
 * Convert a string to an int and print.
 * Catch exceptions if string cannot be converted to int
 */
public class Exceptions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        try {
            int data = Integer.valueOf(Integer.parseInt(S));
            System.out.println(data);
        } catch(NumberFormatException e) {
            System.out.println("Bad data");
        }
    }
}
