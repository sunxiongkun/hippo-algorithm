package com.sxk.lc.binary;

/**
 * 二分查找变形：最大最小值、旋转排序数组、平方根
 */
public class BinaryAdvanced {

  static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

  static int[] rotateArray = {6, 7, 8, 9, 1, 2, 3, 4, 5};

  public static void main(String[] args) {
    System.out.println(findMin(array));

    System.out.println(searchRotateArray(rotateArray, 2));

    System.out.println(sqrt(10000));
  }

  public static int findMin(int[] array) {
    int start = 0;
    int end = array.length - 1;
    int target = array[end];

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] <= target) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if (array[start] <= target) {
      return array[start];
    } else {
      return array[end];
    }

  }

  public static int searchRotateArray(int[] array, int target) {

    int start = 0;
    int end = array.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] == target) {
        return mid;
      }

      if (array[start] < array[mid]) {
        if (array[start] <= target && target <= array[mid]) {
          end = mid;
        } else {
          start = mid;
        }
      } else {
        if (array[mid] <= target && target <= array[end]) {
          start = mid;
        } else {
          end = mid;
        }
      }

    }

    if (array[start] == target) {
      return start;
    }
    if (array[end] == target) {
      return end;
    }

    return -1;
  }

  public static int sqrt(int x) {
    int start = 1;
    int end = x;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (mid * mid <= x) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (end * end == x) {
      return end;
    } else {
      return start;
    }
  }

}
