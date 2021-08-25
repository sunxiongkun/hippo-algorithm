package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;
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
}
