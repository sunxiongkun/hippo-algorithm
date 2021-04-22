package com.sxk.lc.tree;

/**
 * @author sxk
 * @date 2021/4/17 8:01 下午
 */
public class PaperFolding {

  public static void main(String[] args) {
    print(1, 3, true);
  }


  /**
   * 折纸 二叉树的中序遍历
   *
   * @param i
   * @param n
   * @param isFold
   */
  public static void print(int i, int n, boolean isFold) {
    if (i > n) {
      return;
    }
    print(i + 1, n, true);
    String s = isFold ? "凹" : "凸";
    System.out.println(s);
    print(i + 1, n, false);
  }

}
