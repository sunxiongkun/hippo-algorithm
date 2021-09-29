package com.sxk.lc.exercise.num;

import java.util.Arrays;

/**
 * @author sxk
 */
public class Code56QuickSort {

  public static void main(String[] args) {
    int[] nums = {6, 2, 4, 2, 4, 8};
    System.out.println(Arrays.toString(nums));
    sortArray(nums);
    System.out.println(Arrays.toString(nums));
  }

  /**
   * 912. 排序数组
   * https://leetcode-cn.com/problems/sort-an-array/
   *
   * @param nums
   * @return
   */
  public static int[] sortArray(int[] nums) {
    process(nums, 0, nums.length - 1);
    return nums;
  }

  public static void process(int[] arr, int L, int R) {
    if (L >= R) {
      return;
    }
    int random = L + (int) (Math.random() * (R - L + 1));
    int[] equalArea = partition(arr, L, R, arr[random]);
    process(arr, L, equalArea[0] - 1);
    process(arr, equalArea[1] + 1, R);
  }


  public static int[] partition(int[] arr, int L, int R, int pivot) {
    int less = L - 1;
    int more = R + 1;
    int cur = L;
    while (cur < more) {
      if (arr[cur] < pivot) {
        swap(arr, ++less, cur++);
      } else if (arr[cur] > pivot) {
        swap(arr, cur, --more);
      } else {
        cur++;
      }
    }
    return new int[]{less + 1, more - 1};
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
