package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sxk
 */
public class Code15TreeRightView {


  public static void main(String[] args) {

  }

  /**
   * 199. 二叉树的右视图
   * https://leetcode-cn.com/problems/binary-tree-right-side-view/
   *
   * @param root
   * @return
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode curNode = queue.poll();
        if (i == size - 1) {
          result.add(curNode.val);
        }
        if (curNode.left != null) {
          queue.offer(curNode.left);
        }
        if (curNode.right != null) {
          queue.offer(curNode.right);
        }
      }
    }
    return result;
  }
}
