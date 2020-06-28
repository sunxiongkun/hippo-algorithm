package com.sxk.lc.array;

import java.util.Arrays;

public class SimpleSort {

  public static void main(String[] args) {
    int[] array = {3, 4, 5, 1, 7, 8, 2, 6, 9};
    System.out.println(Arrays.toString(array));
    //bubbleSort(array);
    selectionSort(array);
    System.out.println(Arrays.toString(array));
  }

  /**
   * 冒泡排序 O(n²)
   */

  public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 1; j < array.length - i; j++) {
        if (array[j] < array[j - 1]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }
  }

  /**
   * 选择排序 O(n²)
   */
  public static void selectionSort(int[] array) {
    int length = array.length;
    int min;
    int temp;
    for (int i = 0; i < length; i++) {
      min = i;
      for (int j = i + 1; j < length; j++) {
        if (array[min] > array[j]) {
          min = j;
        }
      }
      temp = array[min];
      array[min] = array[i];
      array[i] = temp;
    }
  }


}
