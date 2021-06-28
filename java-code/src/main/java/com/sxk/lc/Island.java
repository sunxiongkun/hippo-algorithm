package com.sxk.lc;

/**
 * @author sxk
 * @date 2021/4/29 8:57 下午
 */
public class Island {

  public static void main(String[] args) {
    int[][] array = {
        {0, 1, 0, 1, 0},
        {1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0}
    };
    System.out.println(islandNum(array));
  }

  public static int islandNum(int[][] array) {
    int res = 0;
    int column = array.length;
    int row = array[0].length;
    for (int i = 0; i < column; i++) {
      for (int j = 0; j < row; j++) {
        if (array[i][j] == 1) {
          inspect(array, i, j, column, row);
          res++;
        }
      }
    }
    return res;
  }

  public static void inspect(int[][] arr, int i, int j, int col, int row) {
    if (i < 0 || i >= col || j < 0 || j >= row || arr[i][j] != 1) {
      return;
    }
    arr[i][j] = 2;
    inspect(arr, i + 1, j, col, row);
    inspect(arr, i - 1, j, col, row);
    inspect(arr, i, j + 1, col, row);
    inspect(arr, i, j - 1, col, row);
  }

}
