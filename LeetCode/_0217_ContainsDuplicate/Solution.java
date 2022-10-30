package _0217_ContainsDuplicate;

import java.util.HashSet;

// Time complexity O(n) due to iterating through the array only one time.
// Space complexity O(n) due to using HashSet data structure.

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>(nums.length);
        // Traverse through nums[]
        for (int i : nums) {
            // If failed to add to HashSet, it contains a duplicate.
            if (!hashSet.add(i)) {
                return true;
            }
        }
        return false;
    }
}
