package com.sxk.lc.exercise.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sxk
 */
public class Code07ThreeNumSum {

  public static void main(String[] args) {

  }

  /**
   * 三数只和
   * 15->https://leetcode-cn.com/problems/3sum/
   *
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    final int n = nums.length;
    if (n < 3) {
      return res;
    }
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      if (nums[i] > 0) {
        break;
      }
      int target = nums[i];
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        if (target + nums[left] + nums[right] == 0) {
          res.add(Arrays.asList(target, nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (target + nums[left] + nums[right] < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }

}
