package com.sxk.lc.exercise.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author sxk
 */
public class Code23StringMinWindow {


  public static void main(String[] args) {
    String s = "ADOBECODEBANC", t = "ABC";
    System.out.println(new Code23StringMinWindow().minWindow(s, t));
  }

  /**
   * 滑动窗口
   * 76. 最小覆盖子串
   * https://leetcode-cn.com/problems/minimum-window-substring/
   *
   * @param s
   * @param t
   * @return
   */
  Map<Character, Integer> ori = new HashMap<>();
  Map<Character, Integer> cnt = new HashMap<>();

  public String minWindow(String s, String t) {
    int tLen = t.length();
    for (int i = 0; i < tLen; i++) {
      char c = t.charAt(i);
      ori.put(c, ori.getOrDefault(c, 0) + 1);
    }
    int l = 0, r = -1;
    int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
    int sLen = s.length();
    while (r < sLen) {
      ++r;
      if (r < sLen && ori.containsKey(s.charAt(r))) {
        cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
      }
      while (check() && l <= r) {
        if (r - l + 1 < len) {
          len = r - l + 1;
          ansL = l;
          ansR = l + len;
        }
        if (ori.containsKey(s.charAt(l))) {
          cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
        }
        ++l;
      }
    }
    return ansL == -1 ? "" : s.substring(ansL, ansR);
  }

  public boolean check() {
    for (Entry<Character, Integer> entry : ori.entrySet()) {
      Character key = entry.getKey();
      Integer val = entry.getValue();
      if (cnt.getOrDefault(key, 0) < val) {
        return false;
      }
    }
    return true;
  }

}
