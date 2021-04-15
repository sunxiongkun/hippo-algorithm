package com.sxk.lc.dp;

/***
 * 动态规划-股票问题
 *
 * base case：
 * dp[-1][k][0] = dp[i][0][0] = 0
 * dp[-1][k][1] = dp[i][0][1] = -infinity
 * 状态转移⽅程：
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 * @author sxk
 * @date 2021/3/20 4:29 下午
 */
public class StockDemo {

  public static void main(String[] args) {
    int[] array = {3, 2, 6, 5, 0, 3};
    System.out.println(maxPrices(array));
  }

  /**
   * k=1交易次数为1 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
   *
   * @param array
   * @return
   */
  public static int maxPrices(int[] array) {
    int n = array.length;
    if (n < 2) {
      return 0;
    }
    int[][] dp = new int[n][2];
    // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
    // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数
    // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
    dp[0][0] = 0;
    dp[0][1] = -array[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + array[i]);
      dp[i][1] = Math.max(dp[i - 1][1], -array[i]);
    }
    return dp[n - 1][0];
  }

  public static int maxPrices2(int[] array) {
    int n = array.length;
    int dp_i_0 = 0;
    int dp_i_1 = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + array[i]);
      dp_i_1 = Math.max(dp_i_1, -array[i]);
    }
    return dp_i_0;
  }


}
