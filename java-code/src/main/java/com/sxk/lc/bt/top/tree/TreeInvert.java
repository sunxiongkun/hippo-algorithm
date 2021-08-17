package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;

/**
 * @author sxk
 */
public class TreeInvert {

  public static void main(String[] args) {

    TreeNode root = BasicTree.createFullBinaryTree();
    System.out.println(root);
    TreeNode newTree = invertTree(root);
    System.out.println(newTree);
  }

  /**
   * https://leetcode-cn.com/problems/invert-binary-tree/
   *
   * @param root
   * @return
   */

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
}
