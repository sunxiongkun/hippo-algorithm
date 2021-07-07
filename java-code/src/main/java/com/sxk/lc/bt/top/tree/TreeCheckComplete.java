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
   * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
   *
   * @param root
   * @return
   */
  public static boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isLeaf = false;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (isLeaf && (cur.left != null || cur.right != null)
            || (cur.left == null && cur.right != null)) {
          return false;
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
        if (cur.left == null && cur.right == null) {
          isLeaf = true;
        }
      }
    }
    return true;
  }


}
