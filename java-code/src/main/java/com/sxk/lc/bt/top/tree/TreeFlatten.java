package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;

/**
 * @author sxk
 */
public class TreeFlatten {


  public static void main(String[] args) {

    TreeNode root = BasicTree.createLeftFullBinaryTree();
    System.out.println(root);
    flatten(root);
    System.out.println(root);

  }

  /**
   * 二叉树展开为链表
   * 114 -> https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
   * 和先序遍历相同
   *
   * @param root
   */
  public static void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);
    //后序遍历的位置
    TreeNode leftNode = root.left;
    TreeNode rightNode = root.right;
    root.left = null;
    root.right = leftNode;

    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = rightNode;
  }


}
