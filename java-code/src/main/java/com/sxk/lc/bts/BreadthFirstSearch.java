package com.sxk.lc.bts;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 宽度优先搜索
 */
public class BreadthFirstSearch extends BasicTree {

  public static void main(String[] args) {
    TreeNode root = createFullBinaryTree();
    System.out.println(levelOrder(root, false));
    System.out.println(levelOrder(root, true));
    System.out.println(zigzagLevelOrder(root));
  }


  /**
   * 二叉树的层次遍历
   * 返回二叉树节点值的层次遍历（逐层从左往右访问）
   * isReverse=true 从叶子节点到跟节点的层遍历
   */
  public static ArrayList<ArrayList<String>> levelOrder(TreeNode root, boolean isReverse) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      ArrayList<String> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.self);
        if (node.leftNode != null) {
          queue.offer(node.leftNode);
        }
        if (node.rightNode != null) {
          queue.offer(node.rightNode);
        }
      }
      result.add(level);
    }
    if (isReverse) {
      Collections.reverse(result);
    }
    return result;
  }

  public static ArrayList<ArrayList<String>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> curtLevel = new Stack<>();
    Stack<TreeNode> nextLevel = new Stack<>();
    Stack<TreeNode> temp;
    curtLevel.push(root);

    boolean normalOrder = true;
    while (!curtLevel.isEmpty()) {
      ArrayList<String> level = new ArrayList<>();
      while (!curtLevel.isEmpty()) {
        TreeNode node = curtLevel.pop();
        level.add(node.self);
        if (normalOrder) {
          if (node.leftNode != null) {
            nextLevel.push(node.leftNode);
          }
          if (node.rightNode != null) {
            nextLevel.push(node.rightNode);
          }
        } else {
          if (node.rightNode != null) {
            nextLevel.push(node.rightNode);
          }
          if (node.leftNode != null) {
            nextLevel.push(node.leftNode);
          }
        }
      }

      result.add(level);
      temp = curtLevel;
      curtLevel = nextLevel;
      nextLevel = temp;
      normalOrder = !normalOrder;
    }
    return result;
  }


}
