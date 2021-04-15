package com.sxk.lc.dp;

/**
 * @author sxk
 * @date 2021/3/27 5:16 下午
 */
public class TablePath {

  public static void main(String[] args) {

    System.out.println(new TablePath().uniquePaths(3, 2));
  }

  /**
   * 最多不同路径 https://leetcode-cn.com/problems/unique-paths/
   *
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; ++i) {
      dp[i][0] = 1;
    }
    for (int j = 0; j < n; ++j) {
      dp[0][j] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[m - 1][n - 1];
  }

  /**
   * 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum/
   *
   * @param grid
   * @return
   */
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    for (int i = 1; i < n; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }

    return dp[m - 1][n - 1];
  }

}
