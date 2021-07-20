package com.sxk.lc.bt.top.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sxk
 */
public class ArrayPermute {

  public static void main(String[] args) {

  }


  /**
   * 数组全排列
   * <p>
   * 46 -> https://leetcode-cn.com/problems/permutations/
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
    for (int j = 0; j < nums.length; j++) {

    }
  }
}
