package com.sxk.lc.exercise.dp;

import java.util.Arrays;

/**
 * @author sxk
 */
public class Code48CoinChange {

  public static void main(String[] args) {

  }

  /**
   * 322. 零钱兑换
   * https://leetcode-cn.com/problems/coin-change/
   *
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 0; i <= amount; i++) {
      for (int coin : coins) {
        if (i - coin < 0) {
          continue;
        }
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    if (dp[amount] == amount + 1) {
      return -1;
    } else {
      return dp[amount];
    }
  }
}
