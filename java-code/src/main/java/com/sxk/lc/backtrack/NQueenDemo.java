package com.sxk.lc.backtrack;

import java.util.Arrays;

/**
 * @author sxk
 * @date 2021/3/22 3:13 下午
 */
public class NQueenDemo {

  public static void main(String[] args) {
    final String[][] result = new NQueenDemo().nQueen(8);
    System.out.println(Arrays.deepToString(result));
  }


  String[][] res = new String[8][8];

  public String[][] nQueen(int n) {
    String[][] board = new String[8][8];
    backtrack(board, n, 0);
    return res;
  }

  public void backtrack(String[][] board, int n, int row) {
    if (n == row) {
      System.arraycopy(board, 0, res, 0, board.length);
      return;
    }
    for (int col = 0; col < n; col++) {
      if (!isValid(board, row, col)) {
        continue;
      }
      board[row][col] = "Q";
      backtrack(board, n, row + 1);
      board[row][col] = ".";
    }
  }

  /**
   * checkerboard
   *
   * @param board 棋盘
   * @param row
   * @param col
   * @return
   */


  boolean isValid(String[][] board, int row, int col) {
    int n = board.length;
    // 检查列是否有皇后互相冲突
    for (int i = 0; i < n; i++) {
      if ("Q".equals(board[i][col])) {
        return false;
      }
    }
    // 检查右上方是否有皇后互相冲突
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
      if ("Q".equals(board[i][j])) {
        return false;
      }
    }
    // 检查左上方是否有皇后互相冲突
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if ("Q".equals(board[i][j])) {
        return false;
      }
    }
    return true;
  }


}
