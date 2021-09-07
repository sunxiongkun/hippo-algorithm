package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code19NumIslands {


  public static void main(String[] args) {

  }

  /**
   * 200. 岛屿数量
   * https://leetcode-cn.com/problems/number-of-islands/
   *
   * @param grid
   * @return
   */

  public int numIslands(char[][] grid) {
    int res = 0;
    if (grid == null || grid.length == 0) {
      return res;
    }
    int row = grid.length;
    int column = grid[0].length;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (grid[r][c] == '1') {
          res++;
          dfs(grid, r, c);
        }
      }
    }

    return res;
  }

  private void dfs(char[][] grid, int r, int c) {
    int row = grid.length;
    int column = grid[0].length;
    if (r < 0 || c < 0 || r >= row || c >= column || grid[r][c] == '0') {
      return;
    }
    grid[r][c] = '0';
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }


}
