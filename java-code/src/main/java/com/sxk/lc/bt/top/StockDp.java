package com.sxk.lc.bt.top;

/**
 * @author sxk https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class StockDp {

  public static void main(String[] args) {
    int[] arr = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(arr));
    System.out.println(maxProfit3(arr));
    System.out.println(maxProfit2(arr));
  }

  /**
   * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
   *
   * @param prices
   * @return
   */
  public static int maxProfit(int[] prices) {
    int length = prices.length;
    int[][] dp = new int[length][length];
    //base case
    for (int l = 0; l < length - 1; l++) {
      dp[l][l + 1] = Math.max(0, prices[l + 1] - prices[l]);
    }

    for (int r = 1; r < length; r++) {
      for (int l = r - 1; l >= 0; l--) {
        dp[l][r] = Math.max(Math.max(dp[l + 1][r], dp[l][r - 1]),
            Math.max(prices[r] - prices[l], dp[l + 1][r - 1]));
      }
    }
    return dp[0][length - 1];
  }

  public static int maxProfit2(int[] prices) {
    return process(prices, 0, prices.length - 1);
  }

  public static int process(int[] prices, int l, int r) {
    if (l >= r) {
      return 0;
    }
    if (l == r - 1) {
      int value = prices[r] - prices[l];
      return Math.max(value, 0);
    }
    int v1 = process(prices, l, r - 1);
    int v2 = process(prices, l + 1, r);
    int v3 = process(prices, l + 1, r - 1);
    int v4 = prices[r] - prices[l];
    return Math.max(Math.max(v1, v2), Math.max(v3, v4));
  }


  public static int maxProfit3(int[] prices) {
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


}
