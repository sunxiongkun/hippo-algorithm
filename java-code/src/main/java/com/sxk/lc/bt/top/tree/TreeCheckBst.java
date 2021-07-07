package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;

/**
 * @author sxk
 */
public class TreeCheckBst {


  public static void main(String[] args) {
    TreeNode root = BasicTree.createFullBinaryTree();
    System.out.println(isValidBST(root));
  }

  /**
   * https://leetcode-cn.com/problems/validate-binary-search-tree/ 中序是升序
   *
   * @param root
   * @return
   */
  static int pre = Integer.MIN_VALUE;

  public static boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isValidBST(root.left)) {
      return false;
    }
    if (root.val <= pre) {
      return false;
    }
    pre = root.val;

    return isValidBST(root.right);
  }

}
