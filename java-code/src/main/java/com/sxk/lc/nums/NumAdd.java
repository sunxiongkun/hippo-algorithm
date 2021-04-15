package com.sxk.lc.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sxk
 * @date 2021/3/31 6:53 下午
 */
public class NumAdd {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(new NumAdd().threeSum(nums));

  }

  /**
   * 两数之和 https://leetcode-cn.com/problems/two-sum/
   *
   * @param nums
   * @param target
   * @return
   */

  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      int he = target - cur;
      if (map.containsKey(he)) {
        return new int[]{map.get(he), i};
      }
      map.put(cur, i);
    }
    return res;
  }

  /***
   * 三数之和 https://leetcode-cn.com/problems/3sum/
   *  1. 如果nums 小于3 返回null
   *  2. 排序
   *  3. nums[i] 为 target
   *     left=i+1;right=length-1
   *     nums[i]+nums[left]+nums[right]==0 继续下个结果
   * @param nums
   * @return
   */

  public List<List<Integer>> threeSum(int[] nums) {
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

}
