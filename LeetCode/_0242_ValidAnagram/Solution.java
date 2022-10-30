package _0242_ValidAnagram;

import java.util.*;

// Time complexity
// Space complexity
public class Solution {
    public boolean isAnagram(String s, String t) {

        // Check if s or t is null
        // If both strings don't have the same length, then they aren't anagrams.
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // Sort both strings using Arrays.sort method
        String firstSort = sortString(s);
        String secondSort = sortString(t);
        return firstSort.equals(secondSort);
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Test the following
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("aacc", "ccac"));
    }
}
