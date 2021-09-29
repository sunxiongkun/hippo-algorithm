package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sxk
 */
public class Code54TreeIsComplete {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    //root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    //root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    System.out.println(isCompleteTree(root));
  }

  /**
   * 958. 二叉树的完全性检验
   * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
   *
   * @param root
   * @return
   */
  public static boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isLeaf = false;
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (isLeaf && cur != null) {
        return false;
      }
      if (cur == null) {
        isLeaf = true;
        continue;
      }
      queue.offer(cur.left);
      queue.offer(cur.right);
    }
    return true;
  }
}
