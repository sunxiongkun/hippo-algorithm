package com.sxk.lc.array;

import java.util.Arrays;

/**
 * @author sxk
 * @date 2021/4/11 10:15 下午 归并
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 6, 4, 9, 5};
    System.out.println(Arrays.toString(arr));
    mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void mergeSort(int[] array) {
    sortProcess(array, 0, array.length - 1);
  }

  public static void sortProcess(int[] array, int l, int r) {
    if (l == r) {
      return;
    }
    int mid = l + (r - l) / 2;
    //左边排序
    sortProcess(array, l, mid);
    //右边排序
    sortProcess(array, mid + 1, r);
    merge(array, l, mid, r);
  }

  public static void merge(int[] array, int l, int mid, int r) {
    int[] help = new int[r - l + 1];
    int i = 0;
    int p1 = l;
    int p2 = mid + 1;
    while (p1 <= mid && p2 <= r) {
      help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
    }
    while (p1 <= mid) {
      help[i++] = array[p1++];
    }
    while (p2 <= r) {
      help[i++] = array[p2++];
    }
    for (int j = 0; j < help.length; j++) {
      array[l + j] = help[j];
    }
  }

}
