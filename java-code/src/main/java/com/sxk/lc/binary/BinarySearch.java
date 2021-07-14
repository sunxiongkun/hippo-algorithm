package com.sxk.lc.binary;

import java.util.Arrays;

/**
 * 前提：排序数组 二分查找
 * @author sxk
 */
public class BinarySearch {

  //升序数组
  static int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

  static int[] array2 = {0, 0, 1, 1, 2, 2};
  static int[] array3 = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6,
      6, 6};

  public static void main(String[] args) {
    System.out.println(findPosition(array, 3));
    System.out.println(findFirstPosition(array2, 1));
    System.out.println(findLastPosition(array2, 1));

    System.out.println(Arrays.toString(searchRange(array2, 2)));
    System.out.println(Arrays.toString(searchRange(array2, 1)));
    System.out.println(Arrays.toString(searchRange(array3, 1)));
  }

  static int findPosition(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid + 1;
      } else if (array[mid] > target) {
        right = mid - 1;
      } else if (array[mid] == target) {
        return mid;
      }
    }
    return -1;
  }

  /**
   * 左边界
   *
   * @param array
   * @param target
   * @return
   */
  static int findFirstPosition(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid + 1;
      } else if (array[mid] > target) {
        right = mid - 1;
      } else if (array[mid] == target) {
        //别返回，锁定左边界
        right = mid - 1;
      }
    }
    // 最后要检查 left 越界的情况
    if (left == array.length || array[left] != target) {
      return -1;
    }
    return left;
  }

  /**
   * 右边界
   *
   * @param array
   * @param target
   * @return
   */
  static int findLastPosition(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid + 1;
      } else if (array[mid] > target) {
        right = mid - 1;
      } else if (array[mid] == target) {
        //别返回，锁定右边界
        left = mid + 1;
      }
    }
    // 最后要检查 right 越界的情况
    if (right < 0 || array[right] != target) {
      return -1;
    }
    return right;

  }

  /***
   * 在排序数组中查找元素的第一个和最后一个位置
   * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
   * @param nums
   * @param target
   * @return
   */
  public static int[] searchRange(int[] nums, int target) {
    final int leftIdx = searchRangeLeft(nums, target);
    if (leftIdx == -1) {
      return new int[]{-1, -1};
    }
    final int rightIdx = searchRangeRight(nums, target);
    return new int[]{leftIdx, rightIdx};
  }

  public static int searchRangeLeft(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      }
      if (nums[mid] > target) {
        right = mid - 1;
      }
      if (nums[mid] == target) {
        right = mid - 1;
      }
    }
    if (left >= nums.length || nums[left] != target) {
      return -1;
    }
    return left;
  }

  public static int searchRangeRight(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      }
      if (nums[mid] > target) {
        right = mid - 1;
      }
      if (nums[mid] == target) {
        left = mid + 1;
      }
    }
    if (right < 0 || nums[right] != target) {
      return -1;
    }

    return right;
  }

}
