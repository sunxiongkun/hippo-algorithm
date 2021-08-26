package com.sxk.lc.exercise.dp;

/**
 * @author sxk
 */
public class Code17MaxSequence {


  public static void main(String[] args) {
    //int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
    int[] array = {4, 10, 4, 3, 8, 9};
    System.out.println(lengthOfLIS(array));
  }

  /**
   * 300. 最长递增子序列
   * https://leetcode-cn.com/problems/longest-increasing-subsequence/
   *
   * @param nums
   * @return
   */
  public static int lengthOfLIS(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[n];
    dp[0] = 1;
    int res = 1;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }

}
