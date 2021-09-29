package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sxk
 */
public class Code53TreePathSum {


  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);

    System.out.println(pathSum(root, 7));
  }

  /**
   * 113. 路径总和 II
   * https://leetcode-cn.com/problems/path-sum-ii/
   *
   * @param root
   * @param targetSum
   * @return
   */
  static List<List<Integer>> result = new ArrayList<>();

  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return result;
    }
    process(root, new LinkedList<>(), targetSum);
    return result;
  }

  public static void process(TreeNode root, LinkedList<Integer> list, int sum) {
    if (root == null) {
      return;
    }
    list.offerLast(root.val);
    if (root.left == null && root.right == null) {
      if (root.val == sum) {
        result.add(new ArrayList<>(list));
      }
    }
    process(root.left, list, sum - root.val);
    process(root.right, list, sum - root.val);
    list.pollLast();
  }
}
