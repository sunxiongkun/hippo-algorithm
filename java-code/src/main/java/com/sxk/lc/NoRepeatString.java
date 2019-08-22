package com.sxk.lc;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatString {

  public static void main(String[] args) {
    String s = "defence";
    //System.out.println(lengthOfLongestSubstring(s));

    Map<Character, Integer> map = new HashMap<>();
    int noRepeatNum = 0;
    for (int start = 0, end = 0; end < s.length(); end++) {
      if (map.containsKey(s.charAt(end))) {
        noRepeatNum = Math.max(noRepeatNum, end - map.get(s.charAt(end)));
        start = end;
      } else {
        noRepeatNum++;
      }
      map.put(s.charAt(end), end);

    }

    System.out.println(noRepeatNum);


  }

  public static int lengthOfLongestSubstring(String s) {
    int noRepeatNum = 1;

    char[] array = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int start = 0, end = 0; end < array.length; end++) {
      if (map.containsKey(array[end])) {
        start = Math.max(map.get(array[end]), start);
      }
      noRepeatNum = Math.max(noRepeatNum, end - start);

      map.put(array[end], end);
    }

    return noRepeatNum + 1;


  }

}
