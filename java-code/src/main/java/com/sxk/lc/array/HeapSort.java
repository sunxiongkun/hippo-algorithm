package com.sxk.lc.array;

import java.util.Arrays;

/**
 * @author sxk
 * @date 2021/5/9 6:34 下午
 */
public class HeapSort {

  public static void main(String[] args) {
    int[] array = {1, 3, 2, 7, 4};
    System.out.println(Arrays.toString(array));
    heapSort(array);
    System.out.println("升序:" + Arrays.toString(array));

  }

  public static void heapSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      heapInsert(arr, i);
    }

    System.out.println("heapInsert 大根堆:" + Arrays.toString(arr));
    int heapSize = arr.length;
    swap(arr, 0, --heapSize);
    // O(N*logN)
    // O(N)
    while (heapSize > 0) {
      // O(logN)
      heapify(arr, 0, heapSize);
      swap(arr, 0, --heapSize);
    }

  }

  public static void heapInsert(int[] arr, int index) {
    while (arr[index] > arr[(index - 1) / 2]) {
      swap(arr, index, (index - 1) / 2);
      index = (index - 1) / 2;
    }
  }

  // arr[index]位置的数，能否往下移动
  public static void heapify(int[] arr, int index, int heapSize) {
    // 左孩子的下标
    int left = index * 2 + 1;
    // 下方还有孩子的时候
    while (left < heapSize) {
      // 两个孩子中，谁的值大，把下标给largest
      // 1）只有左孩子，left -> largest
      // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
      // 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子的值， right -> largest
      int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
      // 父和较大的孩子之间，谁的值大，把下标给largest
      largest = arr[largest] > arr[index] ? largest : index;
      if (largest == index) {
        break;
      }
      swap(arr, largest, index);
      index = largest;
      left = index * 2 + 1;
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
