package com.sxk.lc.dp;

/**
 * @author sxk
 * @date 2021/3/29 2:47 下午
 */
public class StairsDp {

  public static void main(String[] args) {
    System.out.println(new StairsDp().climbStairs(5));
  }

  /***
   * 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
   *
   * dp[x]=dp[x-1]+dp[x-2]
   *
   * @param n
   * @return
   */

  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  /**
   * 用滚动数组实现
   *
   * @param n
   * @return
   */
  public int climbStairs2(int n) {
    int cur = 0, pre = 0, res = 1;
    for (int i = 0; i < n; i++) {
      pre = cur;
      cur = res;
      res = pre + cur;
    }
    return res;
  }


}
