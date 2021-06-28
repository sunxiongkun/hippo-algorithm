package com.sxk.lc.dp.recursive;

/**
 * @author sxk
 * @date 2021/4/24 6:03 下午
 */
public class Nqueen {

  public static void main(String[] args) {

    System.out.println(nqueen(2));
    System.out.println(nqueen(4));
    System.out.println(nqueen(5));

  }

  public static int nqueen(int n) {
    if (n < 0) {
      return 0;
    }
    int[] records = new int[n];
    return process(records, 0, n);
  }

  public static int process(int[] records, int i, int n) {
    if (i == n) {
      return 1;
    }
    int res = 0;
    //尝试i行所有列
    for (int j = 0; j < n; j++) {
      if (isValid(records, i, j)) {
        records[i] = j;
        res += process(records, i + 1, n);
      }
    }
    return res;
  }

  /**
   * 检测0...i之前的行的皇后
   *
   * @param records
   * @param column
   * @param row
   * @return
   */
  public static boolean isValid(int[] records, int column, int row) {
    for (int preColumn = 0; preColumn < column; preColumn++) {
      // preColumn records[preColumn] column,row
      //records[preColumn] == row 共列
      //
      if (records[preColumn] == row || Math.abs(preColumn - column) == Math
          .abs(records[preColumn] - row)) {
        return false;
      }
    }
    return true;
  }

}
