package com.sxk.lc.exercise.num;

import java.util.Arrays;

/**
 * @author sxk
 */
public class Code14NumPermutation {

  public static void main(String[] args) {
    int[] array = {4, 5, 2, 6, 3, 1};
    int[] nextArray = {4, 5, 3, 1, 2, 6};
    System.out.println(Arrays.toString(array));

    nextPermutation(array);
    System.out.println(Arrays.toString(array));

    assert array == nextArray;

  }

  /**
   * [1,2,3]的字典序排序如下:
   * [1,2,3]
   * [1,3,2]
   * [2,1,3]
   * [2,3,1]
   * [3,1,2]
   * [3,2,1]
   * 31. 下一个排列
   * https://leetcode-cn.com/problems/next-permutation/
   *
   * @param nums
   */
  public static void nextPermutation(int[] nums) {
    // int[] array = {4, 5, 2, 6, 3, 1}; 得到i 为2 的下标 j为3的下标

    int i = nums.length - 2;
    while (i >= 0 && nums[i] > nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] > nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void reverse(int[] nums, int start) {
    int left = start, right = nums.length - 1;
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }


  }


}
