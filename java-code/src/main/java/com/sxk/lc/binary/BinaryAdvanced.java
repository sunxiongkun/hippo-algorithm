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


  /**
   * 两次二分法:
   * 第一次：start和mid比较，判断是在左上还是右下：A[start] < A[mid]在左上；A[start] > A[mid] 在右下
   * 第二次：在有解的那一半中继续二分：
   * 左上start<=target<=mid end = mid;否则start = mid;
   * 右下mid<=target<=end start = mid;否则end = mid;
   */
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
