package _0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strings) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String s : strings) {
      char[] count = new char[26];

      // Increase count for each character occurrence in each string
      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }

      String key = new String(count);

      map.computeIfAbsent(key, k -> new ArrayList<>());
      map.get(key).add(s);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    Solution test = new Solution();
    String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> answer = test.groupAnagrams(strings);
    for (List<String> stringList : answer) {
      System.out.print(stringList + ", ");
    }
  }
}
