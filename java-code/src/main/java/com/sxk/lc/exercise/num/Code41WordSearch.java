package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code41WordSearch {

  public static void main(String[] args) {

    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'},
    };

    System.out.println(exist(board, "ABC"));

  }

  /**
   * 79. 单词搜索
   * https://leetcode-cn.com/problems/word-search/
   *
   * @param board
   * @param word
   * @return
   */
  public static boolean exist(char[][] board, String word) {
    int rows = board.length;
    if (rows == 0) {
      return false;
    }
    int columns = board[0].length;
    if (columns == 0) {
      return false;
    }
    char[] charArray = word.toCharArray();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (board[i][j] == charArray[0]) {
          if (exist(board, i, j, charArray, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  //回溯
  public static boolean exist(char[][] board, int row, int column, char[] charArray, int point) {
    int rows = board.length;
    int columns = board[0].length;
    if (row < 0 || column < 0 || row >= rows || column >= columns) {
      return false;
    }
    // 以 row,column为起点，在board，上有以point为起点 word后续的字符串吗？
    if (board[row][column] != charArray[point]) {
      return false;
    }
    if (point == charArray.length - 1) {
      return true;
    }
    char temp = board[row][column];
    board[row][column] = '!';
    if (exist(board, row, column + 1, charArray, point + 1)) {
      return true;
    }
    if (exist(board, row, column - 1, charArray, point + 1)) {
      return true;
    }
    if (exist(board, row + 1, column, charArray, point + 1)) {
      return true;
    }
    if (exist(board, row - 1, column, charArray, point + 1)) {
      return true;
    }
    board[row][column] = temp;
    return false;
  }

}
