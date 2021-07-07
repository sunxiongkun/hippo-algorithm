package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sxk
 */
public class TreeRightView {

  public static void main(String[] args) {

    TreeNode root = BasicTree.createFullBinaryTree();
    System.out.println(rightSideView(root));
    TreeNode root1 = BasicTree.createLeftFullBinaryTree();
    System.out.println(rightSideView(root1));
  }

  /**
   * https://leetcode-cn.com/problems/binary-tree-right-side-view/
   *
   * @param root
   * @return
   */
  public static List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (i + 1 == size) {
          result.add(cur.val);
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return result;
  }

}
