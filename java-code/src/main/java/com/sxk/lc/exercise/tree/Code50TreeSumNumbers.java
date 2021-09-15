package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 */
public class Code50TreeSumNumbers {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);

    System.out.println(sumNumbers(root));
  }

  /**
   * 129. 求根节点到叶节点数字之和
   * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
   *
   * @param root
   * @return
   */
  public static int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }

  public static int dfs(TreeNode root, int preSum) {
    if (root == null) {
      return 0;
    }
    int sum = preSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      return sum;
    } else {
      return dfs(root.left, sum) + dfs(root.right, sum);
    }
  }

}

