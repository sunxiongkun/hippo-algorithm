package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;

/**
 * @author sxk
 */
public class TreeSymmetric {


  public static void main(String[] args) {
    TreeNode root = BasicTree.createFullBinaryTree();
    System.out.println(isSymmetric(root));
    System.out.println(isSymmetric(BasicTree.createLeftFullBinaryTree()));
  }

  /**
   * https://leetcode-cn.com/problems/symmetric-tree/
   *
   * @param root
   * @return
   */
  public static boolean isSymmetric(TreeNode root) {
    return check(root, root);
  }

  public static boolean check(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    return root1.val == root2.val && check(root1.left, root2.right) && check(root1.right,
        root2.left);

  }


}
