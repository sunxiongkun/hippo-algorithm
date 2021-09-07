package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 */
public class Code35TreeSymmetric {

  public static void main(String[] args) {

  }

  /**
   * 101. 对称二叉树
   * https://leetcode-cn.com/problems/symmetric-tree/
   *
   * @param root
   * @return
   */

  public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root, root);
  }

  public boolean isSymmetric(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(
        root1.right, root2.left);
  }
}
