package com.sxk.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class TwoNumberSum {

  public static void main(String[] args) {
    Integer[] array = new Integer[]{1, 2, 4, 5};

    Integer[] result = towNumberSum(array, 7);
    System.out.println(Arrays.toString(result));
  }

  public static Integer[] towNumberSum(Integer[] array, Integer target) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      int cur = target - array[i];
      if (map.containsKey(cur)) {
        return new Integer[]{i, map.get(cur)};
      }
      map.put(array[i], i);
    }

    return new Integer[]{};
  }

}


