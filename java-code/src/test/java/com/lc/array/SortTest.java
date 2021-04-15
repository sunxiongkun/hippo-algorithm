package com.lc.array;

import java.util.Arrays;

/**
 * @author sxk
 * @date 2021/4/11 5:51 下午
 */
public class SortTest {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 5, 4, 9, 6};
    System.out.println(Arrays.toString(arr));
    //bubbleSort(arr);
    selectSort(arr);
    insertSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void bubbleSort(int[] arr) {
    final int length = arr.length;
    for (int end = length - 1; end > 0; end--) {
      for (int j = 0; j < end; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }

  public static void selectSort(int[] arr) {
    final int length = arr.length;
    for (int i = 0; i < length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < length; j++) {
        minIndex = arr[j] < arr[minIndex] ? j : minIndex;
      }
      swap(arr, i, minIndex);
    }
  }

  public static void insertSort(int[] arr) {
    final int length = arr.length;
    for (int i = 1; i < length; i++) {
      for (int j = i; j > 1 && arr[j] < arr[j - 1]; j--) {
        swap(arr, arr[j], arr[j - 1]);
      }
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
