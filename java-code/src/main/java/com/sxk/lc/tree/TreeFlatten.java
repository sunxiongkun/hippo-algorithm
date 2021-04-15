package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/3/23 2:15 下午
 */
public class TreeFlatten extends BasicTree {

  public static void main(String[] args) {
    TreeNode root = createFullBinaryTree();
    final TreeFlatten treeFlatten = new TreeFlatten();
    treeFlatten.flatten(root);
    System.out.println(root);
  }


  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flatten(root.left);
    flatten(root.right);

    // 后序遍历位置
    // 1、左右子树已经被拉平成一条链表
    TreeNode left = root.left;
    TreeNode right = root.right;

    // 2、将左子树作为右子树
    root.left = null;
    root.right = left;

    // 3、将原先的右子树接到当前右子树的末端
    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;
  }
}