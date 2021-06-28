package com.sxk.lc.dp.recursive;

/**
 * @author sxk
 * @date 2021/5/12 9:48 上午
 */
public class RobotWalk {

  public static void main(String[] args) {

    int n = 7;
    int start = 3;
    int aim = 4;
    int k = 3;
    System.out.println(ways1(n, start, aim, k));
    System.out.println(dpWalk(n, start, aim, k));
  }

  public static int ways1(int N, int start, int aim, int K) {
    if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
      return -1;
    }
    return walk(start, K, aim, N);
  }

  // 机器人当前来到的位置是cur，
  // 机器人还有rest步需要去走，
  // 最终的目标是aim，
  // 有哪些位置？1~N
  // 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
  public static int walk(int cur, int rest, int aim, int N) {
    if (rest == 0) { // 如果已经不需要走了，走完了！
      return cur == aim ? 1 : 0;
    }
    //如果在1位置，只能走向2位置
    if (cur == 1) { // 1 -> 2
      return walk(2, rest - 1, aim, N);
    }

    // 如果在最后一个位置，只能走到n-1的位置
    if (cur == N) { // N-1 <- N
      return walk(N - 1, rest - 1, aim, N);
    }
    // 可以向左走也可以向右走
    return walk(cur - 1, rest - 1, aim, N) + walk(cur + 1, rest - 1, aim, N);
  }

  public static int dpWalk(int N, int start, int aim, int K) {
    if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
      return -1;
    }
    int[][] dp = new int[N + 1][K + 1];
    dp[aim][0] = 1;
    for (int rest = 1; rest <= K; rest++) {
      dp[1][rest] = dp[2][rest - 1];
      for (int cur = 2; cur < N; cur++) {
        dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
      }
      dp[N][rest] = dp[N - 1][rest - 1];
    }
    return dp[start][K];
  }


}
