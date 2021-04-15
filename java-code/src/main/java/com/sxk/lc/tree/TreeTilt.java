package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/3/24 8:49 下午
 */
public class TreeTilt extends BasicTree {

  public static void main(String[] args) {
    final TreeNode root = createFullBinaryTree();
    System.out.println(new TreeTilt().findTilt(root));
  }

  int tilt = 0;

  public int findTilt(TreeNode root) {
    treeValue(root);
    return tilt;
  }

  public int treeValue(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftVal = treeValue(root.left);
    int rightVal = treeValue(root.right);
    tilt += Math.abs(leftVal - rightVal);
    return leftVal + rightVal + root.val;
  }

}
