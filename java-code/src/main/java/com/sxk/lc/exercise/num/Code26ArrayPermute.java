package com.sxk.lc.exercise.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sxk
 */
public class Code26ArrayPermute {

  public static void main(String[] args) {

  }

  /**
   * 46. 全排列
   * https://leetcode-cn.com/problems/permutations/
   *
   * @param nums
   * @return
   */
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    process(nums, 0, res);
    return res;
  }

  public static void process(int[] nums, int i, List<List<Integer>> res) {
    if (i == nums.length - 1) {
      List<Integer> collect = Arrays
          .stream(nums)
          .boxed()
          .collect(Collectors.toList());
      res.add(collect);
      return;
    }
    for (int j = i; j < nums.length; j++) {
      swap(nums, i, j);
      process(nums, i + 1, res);
      swap(nums, j, i);
    }
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
