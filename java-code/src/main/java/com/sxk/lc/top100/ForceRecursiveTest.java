package com.sxk.lc.top100;

/**
 * @author sxk
 */
public class ForceRecursiveTest {

  public static void main(String[] args) {
    System.out.println(nQueenProcess(0, new int[5], 5));
    int[] w = new int[]{2, 4, 5, 3};
    int[] p = new int[]{20, 40, 50, 30};
    System.out.println(maxPrice(w, p, 0, 6));
  }

  /***
   * 0~i 已经做完选择
   * i~n i之后最多方法
   *
   *
   * @param i
   * @param record
   * @param n
   * @return
   */
  public static int nQueenProcess(int i, int[] record, int n) {
    if (i == n) {
      return 1;
    }
    int res = 0;
    for (int j = 0; j < n; j++) {
      if (isValid(record, i, j)) {
        record[i] = j;
        res += nQueenProcess(i + 1, record, n);
      }
    }
    return res;
  }

  public static boolean isValid(int[] record, int i, int j) {
    for (int k = 0; k < i; k++) {
      if (record[k] == j || Math.abs(k - i) == Math.abs(record[k] - j)) {
        return false;
      }
    }
    return true;
  }


  /***
   * 0~i 已经做了选择
   * i... 之后的最大价值
   *
   * @param w
   * @param p
   * @param index
   * @param rest
   */
  public static int maxPrice(int[] w, int[] p, int index, int rest) {
    if (rest < 0) {
      return -1;
    }
    if (index == w.length) {
      return 0;
    }
    final int noSelectPrice = maxPrice(w, p, index + 1, rest);
    final int selectPrice = maxPrice(w, p, index + 1, rest - w[index]);
    int price2 = -1;
    if (selectPrice != -1) {
      price2 = selectPrice + p[index];
    }
    return Math.max(noSelectPrice, price2);
  }

  // 机器人当前来到的位置是cur，
  // 机器人还有rest步需要去走，
  // 最终的目标是aim，
  // 有哪些位置？1~N
  // 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
  public static int robotWalk(int cur, int rest, int aim, int n) {
    if (rest == 0) {
      return cur == aim ? 1 : 0;
    }
    if (cur == 1) {
      return robotWalk(2, rest - 1, aim, n);
    }
    if (cur == n) {
      return robotWalk(n - 1, rest - 1, aim, n);
    }
    return robotWalk(cur - 1, rest - 1, aim, n) + robotWalk(cur + 1, rest - 1, aim, n);
  }

  public static int ways1(int start, int k, int aim, int n) {
    int[][] dp = new int[n + 1][k + 1];
    dp[aim][0] = 1;
    for (int rest = 1; rest <= k; rest++) {
      dp[1][rest] = dp[2][rest - 1];
      for (int cur = 2; cur < n - 1; cur++) {
        dp[cur][rest] = dp[cur + 1][rest - 1] + dp[cur - 1][rest - 1];
      }
      dp[n][rest] = dp[n - 1][rest - 1];
    }

    return dp[start][k];
  }

}
