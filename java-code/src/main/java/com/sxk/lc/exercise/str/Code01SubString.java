package com.sxk.lc.exercise.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class Code01SubString {

  public static void main(String[] args) {

  }

  /**
   * 无重复字符的最长子串
   * 3 ->  https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = s.toCharArray();
    int left = 0;
    int res = 0;
    for (int i = 0; i < chars.length; i++) {
      char curChar = chars[i];
      if (map.containsKey(curChar)) {
        left = Math.max(left, map.get(curChar) + 1);
      }
      res = Math.max(res, i - left + 1);
      map.put(curChar, i);
    }
    return res;
  }

}
