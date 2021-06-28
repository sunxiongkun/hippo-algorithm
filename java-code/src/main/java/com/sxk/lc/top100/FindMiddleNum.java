package com.sxk.lc.top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sxk
 * @date 2021/5/9 7:24 下午
 */
public class FindMiddleNum {

  public static void main(String[] args) {
    int[] array0 = {1, 2, 3, 5, 7, 6, 3};
    final int[] partition = partition(array0, 0, array0.length - 1, 3);
    System.out.println(Arrays.toString(partition));
    int[] array1 = {1, 2, 3, 5, 7, 6, 3};
    quickSort(array1);
    System.out.println(Arrays.toString(array1));

    int[] nums1 = {1, 2};
    int[] nums2 = {3, 4};
    int[] array = {3, 1, 5, 7, 9, 4};
    System.out.println(minKth1(array, 3));
    System.out.println(findMedianSortedArrays(nums1, nums2));

  }

  /**
   * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
   *
   * @param nums1
   * @param nums2
   * @return
   */

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double res = 0;
    final int[] sortNums = merge(nums1, nums2);
    System.out.println(Arrays.toString(sortNums));

    if (sortNums.length % 2 == 0) {
      res =
          ((double) sortNums[sortNums.length / 2 - 1] + (double) sortNums[sortNums.length / 2]) / 2;
    } else {
      res = sortNums[sortNums.length / 2];
    }
    return res;
  }

  public static int[] merge(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length + nums2.length];
    int i = 0;
    int first = 0;
    int second = 0;
    while (first < nums1.length && second < nums2.length) {
      if (nums1[first] < nums2[second]) {
        res[i++] = nums1[first++];
      } else {
        res[i++] = nums2[second++];
      }
    }
    while (first < nums1.length) {
      res[i++] = nums1[first++];
    }
    while (second < nums2.length) {
      res[i++] = nums2[second++];
    }
    return res;
  }


  public static int minKth1(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < k; i++) {
      heap.offer(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      if (arr[i] < heap.element()) {
        heap.poll();
        heap.offer(arr[i]);
      }
    }
    return heap.element();
  }

  public static int[] partition(int[] arr, int L, int R, int pivot) {
    int less = L - 1;
    int more = R + 1;
    int index = L;
    while (index < more) {
      if (arr[index] < pivot) {
        swap(arr, ++less, index++);
      } else if (arr[index] > pivot) {
        swap(arr, index, --more);
      } else {
        index++;
      }
    }
    return new int[]{less + 1, more - 1};
  }


  public static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void quickSort(int[] arr) {
    process(arr, 0, arr.length - 1);

  }

  public static void process(int[] arr, int l, int r) {
    if (l >= r) {
      return;
    }
    int pivot = l + (int) (Math.random() * (r - l + 1));
    final int[] equalArea = partition(arr, l, r, pivot);
    process(arr, l, equalArea[0] - 1);
    process(arr, equalArea[1] + 1, r);
  }

}
