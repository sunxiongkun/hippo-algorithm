package com.sxk.lc.bt.top.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 */
public class MatrixZigZag {

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};
    List<Integer> list = spiralOrder(matrix);
    System.out.println(list);

    zigZagOrder(matrix);
  }

  /**
   * 螺旋打印
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


  public static void zigZagOrder(int[][] matrix) {
    int startRow = 0;
    int startCol = 0;
    //destination
    int destRow = 0;
    int destCol = 0;
    int endRow = matrix.length - 1;
    int endCol = matrix[0].length - 1;
    boolean isFlag = true;
    while (startRow != endRow + 1) {
      print(matrix, startRow, startCol, destRow, destCol, isFlag);
      if (startCol != endCol) {
        startCol++;
      } else {
        startRow++;
      }
      if (destRow != endRow) {
        destRow++;
      } else {
        destCol++;
      }
      isFlag = !isFlag;
    }
  }

  public static void print(int[][] matrix, int startRow, int startCol, int destRow, int destCol,
      boolean isFlag) {
    if (isFlag) {
      while (startRow != destRow + 1) {
        System.out.print(matrix[startRow++][startCol--] + " ");
      }
    } else {
      while (destRow != startRow - 1) {
        System.out.print(matrix[destRow--][destCol++] + " ");
      }
    }

  }

}
