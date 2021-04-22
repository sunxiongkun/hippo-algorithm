package com.sxk.lc.binary;

/**
 * @author sxk
 * @date 2021/4/21 9:36 上午
 */
public class FindPeak {

  public static void main(String[] args) {
    int[] nums = {1, 2, 5, 2, 7, 9, 4};
    System.out.println(findPeakElement(nums));
  }

  /***
   * 峰值元素是指其值大于左右相邻值的元素。
   * https://leetcode-cn.com/problems/find-peak-element/
   * 你可以假设 nums[-1] = nums[n] = -∞
   * @param nums
   * @return
   */
  public static int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[mid + 1]) {
        right = mid;
      }
      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      }
    }
    return left;
  }

}
