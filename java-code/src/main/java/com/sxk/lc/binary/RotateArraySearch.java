package com.sxk.lc.binary;

/**
 * @author sxk
 * @date 2021/4/19 9:04 下午
 */
public class RotateArraySearch {

  public static void main(String[] args) {
    int[] arr1 = {5, 6, 7, 8, 9, 1, 2, 3};
    int[] arr2 = {1, 2, 3};
    System.out.println(search(arr1, 6));
    System.out.println(search(arr2, 1));
  }


  /***
   * 旋转数组中搜索 target
   * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
   * @param nums
   * @param target
   * @return
   */
  public static int search(int[] nums, int target) {
    final int n = nums.length;
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      //0~mid有序
      if (nums[0] <= nums[mid]) {
        if (nums[0] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        //mid~r 有序
      } else {
        if (nums[mid] < target && target <= nums[n - 1]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;

  }
}

