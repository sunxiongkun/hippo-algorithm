package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;

/**
 * @author sxk
 */
public class TreeMirror {


  public static void main(String[] args) {
    TreeNode root = BasicTree.createFullBinaryTree();

    System.out.println(root);

    TreeNode root1 = mirrorTree(root);

    System.out.println(root1);

  }

  /**
   * 剑指 Offer 27. 二叉树的镜像
   * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
   *
   * @param root
   * @return
   */
  public static TreeNode mirrorTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = mirrorTree(root.left);
    TreeNode right = mirrorTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
}
