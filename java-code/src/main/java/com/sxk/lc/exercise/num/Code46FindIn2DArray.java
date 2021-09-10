package com.sxk.lc.exercise.num;

/**
 * @author sxk
 * 创建日期: 2021/9/9
 * @description:
 */
public class Code46FindIn2DArray {

  public static void main(String[] args) {

  }

  /**
   * 剑指 Offer 04. 二维数组中的查找
   * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
   * <p>
   * O(m+n)
   *
   * @param target
   * @param matrix
   * @return
   */
  public boolean findNumberIn2DArray(int target, int[][] matrix) {
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
