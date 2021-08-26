package com.sxk.lc.exercise.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 */
public class Code18MatrixOrder {


  /**
   * 54. 螺旋矩阵
   * https://leetcode-cn.com/problems/spiral-matrix/
   *
   * @param matrix
   * @return
   */
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    //左上角
    int leftUpRow = 0;
    int leftUpCol = 0;
    //右下角
    int rightDownRow = matrix.length - 1;
    int rightDownCol = matrix[0].length - 1;
    while (leftUpRow <= rightDownRow && leftUpCol <= rightDownCol) {
      process(matrix, leftUpRow++, leftUpCol++, rightDownRow--, rightDownCol--, res);
    }
    return res;
  }

  public static void process(int[][] matrix, int leftUpRow, int leftUpCol, int rightDownRow,
      int rightDowCol, List<Integer> res) {
    if (leftUpRow == rightDownRow) {
      for (int col = leftUpCol; col <= rightDowCol; col++) {
        res.add(matrix[leftUpRow][col]);
      }
    } else if (leftUpCol == rightDowCol) {
      for (int row = leftUpRow; row <= rightDownRow; row++) {
        res.add(matrix[row][leftUpCol]);
      }
    } else {
      int curRow = leftUpRow;
      int curCol = leftUpCol;
      while (curCol != rightDowCol) {
        res.add(matrix[leftUpRow][curCol]);
        curCol++;
      }
      while (curRow != rightDownRow) {
        res.add(matrix[curRow][curCol]);
        curRow++;
      }
      while (curCol != leftUpRow) {
        res.add(matrix[rightDownRow][curCol]);
        curCol--;
      }
      while (curRow != leftUpRow) {
        res.add(matrix[curRow][curCol]);
        curRow--;
      }
    }
  }

}
