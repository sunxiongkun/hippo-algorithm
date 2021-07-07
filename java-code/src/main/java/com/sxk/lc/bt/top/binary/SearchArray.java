package com.sxk.lc.bt.top.binary;

/**
 * @author sxk
 */
public class SearchArray {

  public static void main(String[] args) {
    int[] arr = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
    System.out.println(search(arr, 6));
  }

  /**
   * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
   *
   * @param nums
   * @param target
   * @return
   */
  public static int search(int[] nums, int target) {
    int left = 0;
    int len = nums.length;
    int right = len - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (nums[middle] == target) {
        return middle;
      }
      //0~middle 升序
      if (nums[0] <= nums[middle]) {
        if (nums[0] <= target && target < nums[middle]) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      } else {
        //middle~r 升序
        if (nums[middle] < target && target <= nums[len - 1]) {
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      }
    }
    return -1;

  }

}
