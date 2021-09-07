package com.sxk.lc.exercise.num;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class Code29TowNumSum {

  public static void main(String[] args) {

    int[] nums = {3, 2, 4};
    System.out.println(Arrays.toString(twoSum(nums, 6)));
  }

  /**
   * 1.两数只和
   * https://leetcode-cn.com/problems/two-sum/
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      int diff = target - cur;
      if (map.containsKey(diff)) {
        return new int[]{map.get(diff), i};
      }
      map.put(cur, i);
    }
    return res;
  }
}
