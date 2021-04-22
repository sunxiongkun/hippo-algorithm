package com.sxk.lc.binary;

/**
 * @author sxk
 * @date 2021/4/21 9:48 上午
 */
public class FindDuplicateNum {

  public static void main(String[] args) {
    int[] nums = {5, 6, 7, 1, 2, 3, 4, 5, 8, 9, 10};
    System.out.println(findDuplicate2(nums));
  }

  /***
   * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），
   * 可知至少存在一个重复的整数。
   * https://leetcode-cn.com/problems/find-the-duplicate-number/
   * @param nums
   * @return
   */
  public static int findDuplicate(int[] nums) {

    return nums[0];
  }

  public static int findDuplicate2(int[] nums) {
    int fast = nums[nums[0]], slow = nums[0];
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }
    int idx = 0;
    while (fast != idx) {
      idx = nums[idx];
      fast = nums[fast];
    }
    return idx;
  }

}
