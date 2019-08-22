package com.sxk.lc.binary;

/**
 * 前提：排序数组
 * 二分查找
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

    int start = 0;
    int end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] == target) {
        return mid;
      }
      if (array[mid] < target) {
        start = mid;
      } else {
        end = mid;
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

  static int findFirstPosition(int[] array, int target) {

    int start = 0;
    int end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] < target) {
        start = mid;
      } else {
        end = mid;
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

  static int findLastPosition(int[] array, int target) {

    int start = 0;
    int end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] > target) {
        end = mid;
      } else {
        start = mid;
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

}
