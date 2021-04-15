package com.sxk.lc.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 * @date 2021/3/31 6:07 下午
 */
public class NoRepeatString {

  public static void main(String[] args) {

    System.out.println(lengthOfLongestSubstring("acabcd"));
    System.out.println(lengthOfLongestSubstring("ac"));
  }


  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int res = 0;
    int left = 0;
    Map<Character, Integer> map = new HashMap<>();
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (map.containsKey(c)) {
        left = Math.max(left, map.get(c) + 1);
      }
      res = Math.max(res, i - left + 1);
      map.put(c, i);
    }
    return res;
  }

}
