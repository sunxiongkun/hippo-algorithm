package com.sxk.lc.dp;

import java.util.Arrays;

/***
 * 动态规划（Dynamic Programming，DP）一般是求最值（最长递增子序列，最短编辑距离）
 * 但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复 杂度，寻找算法低效的原因都有巨⼤帮助
 * 最优⼦结构，⼦问题间必须互相独⽴
 * @author sxk
 * @date 2021/3/19 11:40 上午
 */
public class CoinDemo {

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int amount = 11;
    final int minNum = new CoinDemo().coinChange(coins, amount);
    System.out.println(minNum);
  }

  /***
   * coins 中是可选硬币⾯值，amount 是⽬标⾦额
   *
   * 给你 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，每种硬 币的数量⽆限，再给⼀个总⾦额 amount ，问你最少需要⼏枚硬币凑出这个 ⾦额，
   * 如果不可能凑出，算法返回 -1 。算法的函数签名如下：
   * // coins 中是可选硬币⾯值，amount 是⽬标⾦额 int coinChange(int[] coins, int amount); 动态规划解题套路框架 30
   * ⽐如说 k = 3 ，⾯值分别为 1，2，5，总⾦额 amount = 11 。那么最少需 要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
   * @param coins
   * @param amount
   * @return
   */
  int coinChange(int[] coins, int amount) {
    return dp2(coins, amount);
  }


  int dp(int[] coins, int n) {
    if (n == 0) {
      return 0;
    }
    if (n < 0) {
      return -1;
    }
    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      int subAmount = dp(coins, n - coin);
      if (subAmount == -1) {
        continue;
      }
      res = Math.min(res, 1 + subAmount);
    }
    if (res == Integer.MAX_VALUE) {
      return -1;
    }
    return res;
  }

  int dp2(int[] coins, int n) {
    int[] dp = new int[n + 1];

    Arrays.fill(dp, n + 1);

    dp[0] = 0;
    for (int i = 0; i < dp.length; i++) {
      for (int coin : coins) {
        if (i - coin < 0) {
          continue;
        }
        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
      }
    }
    return (dp[n] == n + 1) ? -1 : dp[n];
  }

}
