package _0001_TwoSums;

import java.util.HashMap;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No solution found.");
  }

  public static void main(String[] args) {
    // Example input
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    TwoSum example = new TwoSum();
    int[] answer = example.twoSum(nums, target);
    for (int i : answer) {
      System.out.print(i + " ");
    }
  }
}
