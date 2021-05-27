public class BinarySearch {
  public static int binarySearchRecursive(int[] array, int firstIndex, int size, int target) {
    int middle;

    // Base case (target not found)
    if (size == 0) {
      return -1;
    } else {
      middle = firstIndex + size / 2;
      if (target == array[middle]) {
        return middle;
      } else if (target < array[middle]) {
        return binarySearchRecursive(array, firstIndex, size / 2, target);
      } else { // if target > array[middle]
        return binarySearchRecursive(array, middle + 1, (size - 1) / 2, target);
      }
    }
  }

  public static int binarySearchIterative(int[] array, int firstIndex, int lastIndex, int target) {
    int middle;

    while (firstIndex <= lastIndex) {
      middle = (firstIndex + lastIndex) / 2;
      if (target == array[middle]) {
        return middle;
      } else if (target < array[middle]) {
        lastIndex = middle - 1;
      } else {
        firstIndex = middle + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // test data
    int[] data = {2, 3, 6, 9, 11, 19, 27, 30};
    System.out.println(binarySearchIterative(data, 0, 7, 30));
  }
}
