package com.sxk.lc.binary;

/**
 * 前提：排序数组 二分查找
 */
public class BinarySearch {

  //升序数组
  static int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

  static int[] array2 = {0, 0, 1, 1, 2, 2};

  public static void main(String[] args) {
    System.out.println(findPosition(array, 3));
    System.out.println(findFirstPosition(array2, 1));
    System.out.println(findLastPosition(array2, 1));
  }

  static int findPosition(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
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
      int mid = (left + right) / 2;
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
    if (left >= array.length || array[left] != target) {
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
      int mid = (left + right) / 2;
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

}
