package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code32NumFindPeak {

  public static void main(String[] args) {

  }

  /**
   * 162. 寻找峰值
   * https://leetcode-cn.com/problems/find-peak-element/
   * <p>
   * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
   *
   * @param nums
   * @return
   */
  public int findPeakElement(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      }
      if (nums[mid] > nums[mid + 1]) {
        right = mid;
      }
    }
    return left;
  }
}
