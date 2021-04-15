package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/3/23 1:59 下午
 */
public class TreeInvert extends BasicTree {

  public static void main(String[] args) {
    final TreeNode root = createFullBinaryTree();
    System.out.println(root);
    System.out.println(new TreeInvert().invertTree(root));
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    /**
     * 反转左右节点
     */
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    /**
     * 左右节点继续反转
     */
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

}
