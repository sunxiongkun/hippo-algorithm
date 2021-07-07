package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;

/**
 * @author sxk
 */
public class TreeDiameter {

  public static void main(String[] args) {
    System.out.println(diameterOfBinaryTree(BasicTree.createLeftFullBinaryTree()));
  }

  /**
   * https://leetcode-cn.com/problems/diameter-of-binary-tree/
   *
   * @param root
   * @return
   */
  public static int diameterOfBinaryTree(TreeNode root) {
    return process(root).distance;
  }

  public static Info process(TreeNode root) {
    if (root == null) {
      return new Info(0, 0);
    }
    Info leftInfo = process(root.left);
    Info rightInfo = process(root.right);

    int height = Math.max(leftInfo.height, rightInfo.height) + 1;
    int distance = Math.max(Math.max(leftInfo.distance, rightInfo.distance),
        leftInfo.height + rightInfo.height);
    return new Info(height, distance);
  }

  private static class Info {

    private int height;
    private int distance;

    public Info(int h, int d) {
      this.height = h;
      this.distance = d;
    }

  }

}
