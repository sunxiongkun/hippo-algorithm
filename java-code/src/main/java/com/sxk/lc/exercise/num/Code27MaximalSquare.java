package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code27MaximalSquare {

  public static void main(String[] args) {

  }

  /**
   * 221. 最大正方形
   * https://leetcode-cn.com/problems/maximal-square/
   *
   * @param matrix
   * @return
   */

  public static int maximalSquare(char[][] matrix) {
    int maxSide = 0;
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return maxSide;
    }
    int rows = matrix.length;
    int columns = matrix[0].length;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        if (matrix[r][c] == '1') {
          // 遇到一个 1 作为正方形的左上角
          maxSide = Math.max(maxSide, 1);
          // 计算可能的最大正方形边长
          int currentMaxSide = Math.min(rows - r, columns - c);
          for (int k = 1; k < currentMaxSide; k++) {
            // 判断新增的一行一列是否均为 1
            boolean flag = true;
            if (matrix[r + k][c + k] == '0') {
              break;
            }
            for (int m = 0; m < k; m++) {
              if (matrix[r + k][c + m] == '0' || matrix[r + m][c + k] == '0') {
                flag = false;
                break;
              }
            }
            if (flag) {
              maxSide = Math.max(maxSide, k + 1);
            } else {
              break;
            }
          }
        }
      }
    }

    return maxSide * maxSide;
  }


  public static int maximalSquare2(char[][] matrix) {
    int maxSide = 0;
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return maxSide;
    }
    int rows = matrix.length;
    int columns = matrix[0].length;
    int[][] dp = new int[rows][columns];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        if (matrix[r][c] == '1') {
          if (r == 0 || c == 0) {
            dp[r][c] = 1;
          } else {
            dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
          }
          maxSide = Math.max(maxSide, dp[r][c]);
        }
      }
    }
    int maximalSquare = maxSide * maxSide;
    return maximalSquare;
  }


}
