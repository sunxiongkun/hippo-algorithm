package com.sxk.lc.bt.top;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class StrMaxSubStr {

  public static void main(String[] args) {
    String str = "ababc";
    System.out.println(lengthOfLongestSubstring(str));

  }

  /**
   * 无重复最长子串
   *
   * @param s
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int ans = 0;
    int left = 0;
    char[] array = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      char cur = array[i];
      if (map.containsKey(cur)) {
        left = Math.max(left, map.get(cur) + 1);
      }
      map.put(cur, i);
      ans = Math.max(ans, i - left + 1);
    }

    return ans;
  }

}
