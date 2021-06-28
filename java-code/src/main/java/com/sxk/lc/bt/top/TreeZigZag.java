package com.sxk.lc.bt.top;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sxk https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class TreeZigZag {


  public static void main(String[] args) {

    TreeNode root = BasicTree.createFullBinaryTree();
    List<List<Integer>> result = zigzagLevelOrder(root);
    System.out.println(result);
    System.out.println(levelOrder(root));

  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<List<Integer>> result = new ArrayList<>();
    Stack<TreeNode> cur = new Stack<>();
    Stack<TreeNode> next = new Stack<>();
    Stack<TreeNode> temp;
    cur.add(root);
    boolean flag = true;
    while (!cur.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      while (!cur.isEmpty()) {
        TreeNode node = cur.pop();
        level.add(node.val);
        if (flag) {
          if (node.left != null) {
            next.add(node.left);
          }
          if (node.right != null) {
            next.add(node.right);
          }
        } else {
          if (node.right != null) {
            next.add(node.right);
          }
          if (node.left != null) {
            next.add(node.left);
          }
        }

      }
      temp = cur;
      cur = next;
      next = temp;
      flag = !flag;
      result.add(level);
    }

    return result;
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        level.add(cur.val);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      result.add(level);
    }

    return result;
  }
}
