package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 */
public class Code28TreeIsBst {

  public static void main(String[] args) {

  }

  /**
   * 98. 验证二叉搜索树
   * https://leetcode-cn.com/problems/validate-binary-search-tree/
   *
   * @param root
   * @return
   */
  long preVal = Long.MIN_VALUE;

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isValidBST(root.left)) {
      return false;
    }
    if (preVal >= root.val) {
      return false;
    }
    preVal = root.val;
    return isValidBST(root.right);
  }

}
