package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sxk
 */
public class Code05TreeLevel {


  public static void main(String[] args) {

  }

  /**
   * 二叉树的锯齿形层序遍历
   * 103 -> https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
   *
   * @param root
   * @return
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> cur = new Stack<>();
    Stack<TreeNode> next = new Stack<>();
    Stack<TreeNode> temp;
    cur.push(root);
    boolean isReverse = true;
    while (!cur.isEmpty()) {
      int size = cur.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode curNode = cur.pop();
        level.add(curNode.val);
        if (isReverse) {
          if (curNode.left != null) {
            next.push(curNode.left);
          }
          if (curNode.right != null) {
            next.push(curNode.right);
          }
        } else {
          if (curNode.right != null) {
            next.push(curNode.right);
          }
          if (curNode.left != null) {
            next.push(curNode.left);
          }
        }
      }
      temp = next;
      next = cur;
      cur = temp;
      isReverse = !isReverse;
      result.add(level);
    }

    return result;
  }


  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
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
