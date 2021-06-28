package com.sxk.lc.middle;

/**
 * @author sxk
 */
public class MaxOneBorderSize {

  public static void main(String[] args) {

  }

  /**
   * @param m
   */
  public static void maxAllOneBorder(int[][] m) {
    int N = m.length;
    int M = m[0].length;
    for (int row = 0; row < N; row++) {
      for (int col = 0; col < M; col++) {
        //枚举边长
        for (int border = 1; border < Math.min(N - row, M - col); border++) {
          //遍历验证边上是否都是1 要遍历4个边

        }
      }
    }

  }

}
