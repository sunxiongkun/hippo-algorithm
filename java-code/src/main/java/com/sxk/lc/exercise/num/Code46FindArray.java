package com.sxk.lc.exercise.num;

/**
 * @author sxk
 * 创建日期: 2021/9/9
 * @description:
 */
public class Code46FindArray {

  public static void main(String[] args) {

  }

  public boolean Find(int target, int[][] matrix) {
    if (matrix == null) {
      return false;
    }
    int rows = matrix.length;
    if (rows == 0) {
      return false;
    }
    int columns = matrix[0].length;
    if (columns == 0) {
      return false;
    }
    if (matrix[0][0] > target) {
      return false;
    }
    if (matrix[rows - 1][columns - 1] < target) {
      return false;
    }
    int row = 0;
    int column = columns - 1;
    while (row < rows && column >= 0) {
      if (matrix[row][column] == target) {
        return true;
      } else if (matrix[row][column] < target) {
        row++;
      } else {
        column--;
      }
    }
    return false;
  }
}
