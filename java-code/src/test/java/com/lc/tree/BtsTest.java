package com.lc.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sxk
 * @date 2021/4/7 7:11 下午
 */
public class BtsTest extends BasicTree {

  public static void main(String[] args) {
    final TreeNode root = createFullBinaryTree();
    System.out.println(zigzagLevelOrder(root));

  }

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> curr = new Stack<>();
    Stack<TreeNode> next = new Stack<>();
    Stack<TreeNode> temp;
    curr.push(root);

    boolean normalOrder = true;
    while (!curr.isEmpty()) {
      final int size = curr.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        final TreeNode node = curr.pop();
        level.add(node.val);
        if (normalOrder) {
          if (node.left != null) {
            next.push(node.left);
          }
          if (node.right != null) {
            next.push(node.right);
          }
        } else {
          if (node.right != null) {
            next.push(node.right);
          }
          if (node.left != null) {
            next.push(node.left);
          }
        }
      }
      normalOrder = !normalOrder;
      temp = curr;
      curr = next;
      next = temp;

      result.add(level);
    }
    return result;
  }
}
