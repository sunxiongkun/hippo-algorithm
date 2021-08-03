package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.LinkedList;

/**
 * @author sxk
 */
public class TreeMaxWidth {

  public static void main(String[] args) {

    TreeNode root = BasicTree.createLeftFullBinaryTree();
    root.right.right.right = new TreeNode(1000);
    System.out.println(widthOfBinaryTree(root));

  }


  /**
   * 二叉树最大宽度
   * 662 -> https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
   *
   * @param root
   * @return
   */
  public static int widthOfBinaryTree(TreeNode root) {
    int res = 0;
    if (root == null) {
      return res;
    }
    LinkedList<Info> queue = new LinkedList<>();
    Info info = new Info(root, 0, 1);
    queue.offer(info);

    while (!queue.isEmpty()) {
      int size = queue.size();
      Info first = queue.getFirst();
      Info last = queue.getLast();
      res = Math.max(last.index - first.index + 1, res);
      for (int i = 0; i < size; i++) {
        Info cur = queue.poll();
        TreeNode node = cur.node;
        if (node.left != null) {
          queue.offer(new Info(node.left, cur.height + 1, 2 * cur.index));
        }
        if (node.right != null) {
          queue.offer(new Info(node.right, cur.height + 1, 2 * cur.index + 1));
        }
      }
    }
    return res;
  }

  private static class Info {

    private TreeNode node;
    private int height;
    private int index;

    public Info(TreeNode node, int height, int index) {
      this.node = node;
      this.height = height;
      this.index = index;
    }

  }

}
