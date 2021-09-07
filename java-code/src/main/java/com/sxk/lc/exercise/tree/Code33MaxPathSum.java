package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 */
public class Code33MaxPathSum {

  public static void main(String[] args) {

  }

  /**
   * 124. 二叉树中的最大路径和
   * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
   *
   * @param root
   * @return
   */

  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }

  public int maxGain(TreeNode node) {
    if (node == null) {
      return 0;
    }
    // 递归计算左右子节点的最大贡献值
    // 只有在最大贡献值大于 0 时，才会选取对应子节点
    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);

    // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
    int priceNewPath = node.val + leftGain + rightGain;

    // 更新答案
    maxSum = Math.max(maxSum, priceNewPath);

    // 返回节点的最大贡献值
    return node.val + Math.max(leftGain, rightGain);
  }
}
