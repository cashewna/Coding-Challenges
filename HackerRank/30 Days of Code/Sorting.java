import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Size of array
        int[] a = new int[n]; // Create a new array of size n
        // Insert elements in a[] from STDIN
        for(int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        Sorting cases = new Sorting();
        int numSwaps = cases.bubbleSort(a);
        cases.printArray(a, numSwaps);
    }

    // Sorts an array in ascending order and return number of swaps
    int bubbleSort(int[] a) {
        int numSwaps = 0;
        int n = a.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    numSwaps++;
                }
            }
        }
        return numSwaps;
    }

    // Print array
    void printArray(int[] a, int numSwaps) {
        int n = a.length; // Array size
        System.out.println("Array is sorted in " + numSwaps + " swaps." +
                "\nFirst Element: " + a[0] +
                "\nLast Element: " + a[n-1]);
    }

}
