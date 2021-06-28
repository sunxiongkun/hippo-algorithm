package com.sxk.lc.dp.recursive;

/**
 * @author sxk
 * @date 2021/4/26 9:22 上午
 */
public class CoinsNum {

  public static void main(String[] args) {
    int[] arr = {10, 20, 50, 100, 200};
    System.out.println(ways1(arr, 500));
    System.out.println(ways2(arr, 500));
  }

  /**
   * 零钱凑到aim目标值有多少种组合
   *
   * @param arr
   * @param aim
   */
  public static int ways1(int[] arr, int aim) {
    return process1(arr, 0, aim);
  }

  /***
   *
   * 可以使用arr[index...]之后的钱的任意数量 达到rest值的方法
   * @param arr
   * @param index
   * @param rest
   * @return
   */
  public static int process1(int[] arr, int index, int rest) {
    /**
     * 数组中所有的选择都没有了，判断rest是否是0
     */
    if (index == arr.length) {
      return rest == 0 ? 1 : 0;
    }
    int ways = 0;
    for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
      ways += process1(arr, index + 1, rest - zhang * arr[index]);
    }
    return ways;
  }

  public static int ways2(int[] arr, int aim) {
    final int N = arr.length;
    int[][] dp = new int[N + 1][aim + 1];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    return process2(arr, 0, aim, dp);
  }

  public static int process2(int[] arr, int index, int rest, int[][] dp) {
    if (dp[index][rest] != -1) {
      return dp[index][rest];
    }
    if (index == arr.length) {
      dp[index][rest] = rest == 0 ? 1 : 0;
      return dp[index][rest];
    }
    int ways = 0;
    for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
      ways += process2(arr, index + 1, rest - zhang * arr[index], dp);
    }
    dp[index][rest] = ways;
    return ways;
  }

}
