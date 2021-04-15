package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 */
public class BinaryTreeDepth extends BasicTree {

  public static void main(String[] args) {
    TreeNode root = createLeftFullBinaryTree();

    System.out.println("最大深度-分治: " + getMaxDepthDivide(root));
    System.out.println("最小深度-分治: " + getMinDepthDivide(root));

  }

  /**
   * 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的距离。
   */

  public static int getMaxDepthDivide(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getMaxDepthDivide(root.left);
    int right = getMaxDepthDivide(root.right);
    return Math.max(left, right) + 1;
  }

  /**
   * 给定一个二叉树，找出其最小深度。二叉树的最小深度为根节点到最近叶子节点的距离
   */
  public static int getMinDepthDivide(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getMinDepthDivide(root.left);
    int right = getMinDepthDivide(root.right);
    return Math.min(left, right) + 1;
  }

}
