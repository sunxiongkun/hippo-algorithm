package com.sxk.lc.dp;

/***
 * 动态规划（Dynamic Programming，DP）
 * 但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复 杂度，寻找算法低效的原因都有巨⼤帮助
 * 最优⼦结构，⼦问题间必须互相独⽴
 *
 * @author sxk
 * @date 2021/3/19 11:06 上午 斐波那契数列
 */
public class FibFunc {

  public static void main(String[] args) {
    System.out.println(fib(20));
    System.out.println(fib2(20));
    System.out.println(fib3(20));
  }

  static int fib(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

  static int fib2(int n) {
    int[] dp = new int[n + 1];
    //base case
    dp[1] = dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  static int fib3(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }
    int pre = 1, current = 1;
    for (int i = 3; i <= n; i++) {
      int sum = pre + current;
      pre = current;
      current = sum;
    }
    return current;
  }

}
