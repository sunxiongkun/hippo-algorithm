package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.LinkedList;
import java.util.Queue;
import lombok.Data;

/**
 * @author sxk
 */
public class TreeCheckComplete {


  public static void main(String[] args) {

    TreeNode root1 = BasicTree.createFullBinaryTree();
    System.out.println(isFullTree(root1));
    System.out.println(isFullTree(BasicTree.createLeftFullBinaryTree()));

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(7);

    System.out.println(root);

    System.out.println(isCompleteTree(root));


  }


  public static boolean isFullTree(TreeNode root) {
    Info info = process(root);
    return info.nodes == Math.pow(2, info.height) - 1;
  }

  @Data
  private static class Info {

    private int height;
    private int nodes;

    public Info(int h, int n) {
      height = h;
      nodes = n;
    }
  }

  public static Info process(TreeNode root) {
    if (root == null) {
      return new Info(0, 0);
    }
    Info leftInfo = process(root.left);
    Info rightInfo = process(root.right);
    int height = Math.max(leftInfo.height, rightInfo.height) + 1;
    int nodes = leftInfo.nodes + rightInfo.nodes + 1;
    return new Info(height, nodes);
  }

  /**
   * 二叉树的完全性检验
   * 958 -> https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
   *
   * @param root
   * @return
   */
  public static boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    boolean isLeaf = false;
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (isLeaf && cur != null) {
        return false;
      }
      if (cur == null) {
        isLeaf = true;
        continue;
      }
      q.offer(cur.left);
      q.offer(cur.right);
    }
    return true;
  }


}
