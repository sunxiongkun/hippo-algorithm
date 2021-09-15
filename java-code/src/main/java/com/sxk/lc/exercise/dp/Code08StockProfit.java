package com.sxk.lc.exercise.dp;

/**
 * @author sxk
 */
public class Code08StockProfit {

  public static void main(String[] args) {

  }

  /**
   * dp[i][0]：规定了今天不持股，有以下两种情况：
   * 昨天不持股，今天什么都不做；
   * 昨天持股，今天卖出股票（现金数增加），
   * <p>
   * dp[i][1]：规定了今天持股，有以下两种情况：
   * 昨天持股，今天什么都不做（现金数与昨天一样）；
   * 昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
   *
   * @param prices
   * @return
   */
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
    // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数
    // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[n - 1][0];

  }

  /**
   * 122. 买卖股票的最佳时机 II
   * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; ++i) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
  }

}
