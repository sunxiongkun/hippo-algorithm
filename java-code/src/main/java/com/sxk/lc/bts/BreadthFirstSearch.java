package com.sxk.lc.bts;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 * 宽度优先搜索
 * 宽度搜索就是层次遍历，层次遍历我们一般借助队列，Z形遍历借助两个stack
 * @author sxk
 */
public class BreadthFirstSearch extends BasicTree {

  public static void main(String[] args) {
    TreeNode root = createFullBinaryTree();
    System.out.println(new BreadthFirstSearch().minDepth(createLeftFullBinaryTree()));
    System.out.println(levelOrder(root, false));
    System.out.println(levelOrder(root, true));
    System.out.println(zigzagLevelOrder(root));
  }


  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int depth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int qz = queue.size();
      for (int i = 0; i < qz; i++) {
        TreeNode cur = queue.poll();
        if (cur.left == null && cur.right == null) {
          return depth;
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      depth++;
    }

    return depth;
  }

  /**
   * 二叉树的层次遍历 返回二叉树节点值的层次遍历（逐层从左往右访问） isReverse=true 从叶子节点到跟节点的层遍历
   */
  public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root, boolean isReverse) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      ArrayList<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(level);
    }
    if (isReverse) {
      Collections.reverse(result);
    }
    return result;
  }

  public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> curtLevel = new Stack<>();
    Stack<TreeNode> nextLevel = new Stack<>();
    Stack<TreeNode> temp;
    curtLevel.push(root);

    boolean normalOrder = true;
    while (!curtLevel.isEmpty()) {
      ArrayList<Integer> level = new ArrayList<>();
      while (!curtLevel.isEmpty()) {
        TreeNode node = curtLevel.pop();
        level.add(node.val);
        if (normalOrder) {
          if (node.left != null) {
            nextLevel.push(node.left);
          }
          if (node.right != null) {
            nextLevel.push(node.right);
          }
        } else {
          if (node.right != null) {
            nextLevel.push(node.right);
          }
          if (node.left != null) {
            nextLevel.push(node.left);
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
