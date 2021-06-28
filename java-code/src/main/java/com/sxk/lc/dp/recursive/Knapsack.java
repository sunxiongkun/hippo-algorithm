package com.sxk.lc.dp.recursive;

/**
 * @author sxk
 * @date 2021/4/24 11:43 上午
 */
public class Knapsack {

  public static void main(String[] args) {
    int[] weight = {1, 3, 4, 2, 5, 2};
    int[] value = {2, 3, 4, 4, 5, 6};
    int bag = 7;
    System.out.println(maxValue(weight, value, bag));
    System.out.println(dp(weight, value, bag));

  }

  public static int maxValue(int[] w, int[] v, int bag) {
    if (w == null || v == null || w.length != v.length || w.length == 0) {
      return 0;
    }
    // 尝试函数！
    return process2(w, v, 0, bag);
  }

  /***
   * 从左向右模型
   * 背包问题（最大价值）
   * 不变的 w,v bag
   * 0...index已经做来选择
   * index...之后的最大价值
   * alreadyW 之前加入的重量
   * 返回：不超重的情况下，能够得到的最大价值
   * @param w
   * @param v
   * @param index
   * @param alreadyW
   * @param bag
   */
  public static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
    if (alreadyW > bag) {
      return -1;
    }
    if (index == w.length) {
      return 0;
    }

    final int price1 = process(w, v, index + 1, alreadyW, bag);
    int priceNext = process(w, v, index + 1, alreadyW + w[index], bag);
    int price2 = -1;
    if (priceNext != -1) {
      price2 = v[index] + priceNext;
    }

    return Math.max(price1, price2);
  }

  /**
   * @param w     重量
   * @param v     价值
   * @param index 0...index 已经做完选择
   * @param rest
   * @return 返回index...之后的最大价值
   */
  public static int process2(int[] w, int[] v, int index, int rest) {
    if (rest < 0) {
      return -1;
    }
    if (index == w.length) {
      return 0;
    }

    final int price1 = process2(w, v, index + 1, rest);
    int priceNext = process2(w, v, index + 1, rest - w[index]);
    int price2 = -1;
    if (priceNext != -1) {
      price2 = v[index] + priceNext;
    }
    return Math.max(price1, price2);
  }

  public static int dp(int[] w, int[] v, int bag) {
    int n = w.length;
    int[][] dp = new int[n + 1][bag + 1];
    for (int index = n - 1; index >= 0; index--) {
      for (int rest = 0; rest <= bag; rest++) {
        dp[index][rest] = dp[index + 1][rest];
        if (rest - w[index] >= 0) {
          int price2 = v[index] + dp[index + 1][rest - w[index]];
          dp[index][rest] = Math.max(dp[index][rest], price2);
        }
      }
    }

    return dp[0][bag];
  }

}
