package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code10RotateArraySearch {

  public static void main(String[] args) {
    int[] nums = {7, 8, 9, 11, 1, 2, 4, 6};
    System.out.println(search(nums, 2));

    nums = new int[]{1, 2, 4, 6, 7, 8, 9, 11};

    System.out.println(binarySearchLeft(nums, 2));
    System.out.println(binarySearchRight(nums, 2));
  }

  /**
   * 33. 搜索旋转排序数组
   * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
   *
   * @param nums
   * @param target
   * @return
   */
  public static int search(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) {
      return -1;
    }
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

  public static int binarySearchLeft(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) {
      return -1;
    }
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (nums[middle] == target) {
        right = middle - 1;
      }
      if (nums[middle] < target) {
        left = middle + 1;
      }
      if (nums[middle] > target) {
        right = middle - 1;
      }
    }
    if (left < n && nums[left] == target) {
      return left;
    }
    return -1;
  }

  public static int binarySearchRight(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) {
      return -1;
    }
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (nums[middle] == target) {
        left = middle + 1;
      }
      if (nums[middle] < target) {
        left = middle + 1;
      }
      if (nums[middle] > target) {
        right = middle - 1;
      }
    }
    if (right > 0 && nums[right] == target) {
      return right;
    }
    return -1;
  }
}
