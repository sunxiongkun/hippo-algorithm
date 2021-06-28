package com.sxk.lc.bt.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sxk https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6};
    System.out.println(twoSum(nums, 6));
    int[] nums2 = {1, 2, -3, 4, 5, -9};
    System.out.println(threeSum(nums2));

  }

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
        if (nums[left] + nums[right] + target == 0) {
          res.add(Arrays.asList(target, nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (nums[left] + nums[right] + target < 0) {
          left++;
        } else if (nums[left] + nums[right] + target > 0) {
          right--;
        }
      }
    }
    return res;
  }


  public static List<List<Integer>> twoSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        result.add(Arrays.asList(i, map.get(diff)));
      }
      map.put(nums[i], i);
    }
    return result;
  }

}
