package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * 对称树
 *
 * @author sxk
 * @date 2021/3/23 3:06 下午
 */
public class TreeSymmetry extends BasicTree {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    TreeNode t11 = new TreeNode(2);
    TreeNode t12 = new TreeNode(2);

    TreeNode t21 = new TreeNode(3);
    TreeNode t22 = new TreeNode(4);
    TreeNode t23 = new TreeNode(4);
    TreeNode t24 = new TreeNode(3);

    root.setLeft(t11);
    root.setRight(t12);

    t11.setLeft(t21);
    t11.setRight(t22);

    t12.setLeft(t23);
    t12.setRight(t24);

    System.out.println(isSameTree(root, createFullBinaryTree()));

    System.out.println(isSymmetric(root));

  }

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p != null && q != null) {
      return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    return false;
  }


  public static boolean isSymmetric(TreeNode root) {
    return check(root, root);
  }


  public static boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
  }


}
