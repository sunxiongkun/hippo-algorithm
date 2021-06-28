package com.sxk.lc.middle;

/**
 * @author sxk
 */
public class MatrixPrint {


  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    printMatrixZigZag(matrix);
    spiralOrderMatrixPrint(matrix);
  }

  /***
   * zigzag打印
   * 0  1   2   3
   * 4  5   6   7
   * 8  9   10  11
   * 0 1 4 8 5 2 3 6 9 10 7 11
   * Row 行
   * column 列
   *
   * @param matrix
   */
  public static void printMatrixZigZag(int[][] matrix) {
    int tR = 0;
    int tC = 0;
    int dR = 0;
    int dC = 0;
    int endR = matrix.length - 1;
    int endC = matrix[0].length - 1;
    boolean fromUp = false;
    while (tR != endR + 1) {
      printLevel(matrix, tR, tC, dR, dC, fromUp);
      tR = tC == endC ? tR + 1 : tR;
      tC = tC == endC ? tC : tC + 1;
      dC = dR == endR ? dC + 1 : dC;
      dR = dR == endR ? dR : dR + 1;
      fromUp = !fromUp;
    }
    System.out.println();
  }

  public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
    if (f) {
      while (tR != dR + 1) {
        System.out.print(m[tR++][tC--] + " ");
      }
    } else {
      while (dR != tR - 1) {
        System.out.print(m[dR--][dC++] + " ");
      }
    }
  }


  /**
   * 螺旋打印
   *
   * @param matrix
   */

  public static void spiralOrderMatrixPrint(int[][] matrix) {
    int tR = 0;
    int tC = 0;
    int dR = matrix.length - 1;
    int dC = matrix[0].length - 1;
    while (tR <= dR && tC <= dC) {
      pintEdge(matrix, tR++, tC++, dR--, dC--);

    }
  }


  public static void pintEdge(int[][] m, int tR, int tC, int dR, int dC) {
    //同一列
    if (tR == dR) {
      for (int i = tC; i <= dC; i++) {
        System.out.print(m[tR][i] + " ");
      }
    } else if (tC == dC) {
      for (int i = tR; i <= dR; i++) {
        System.out.print(m[i][tC] + " ");
      }
    } else {
      int curC = tC;
      int curR = tR;
      while (curC != dC) {
        System.out.print(m[tR][curC] + " ");
        curC++;
      }
      while (curR != dR) {
        System.out.print(m[curR][dC] + " ");
        curR++;
      }
      while (curC != tC) {
        System.out.print(m[dR][curC] + " ");
        curC--;
      }
      while (curR != tR) {
        System.out.print(m[curR][tC] + " ");
        curR--;
      }
    }

  }

}
