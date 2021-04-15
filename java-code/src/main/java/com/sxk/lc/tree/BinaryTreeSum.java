package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/3/16 5:35 下午
 */
public class BinaryTreeSum extends BasicTree {

  public static void main(String[] args) {
    final TreeNode root = createFullBinaryTree();
    System.out.println(root);
    System.out.println(new BinaryTreeSum().maxPathSum(root));

  }

  static int maxSum = Integer.MIN_VALUE;

  /**
   * 最大路径和/最优路径
   *
   * @param root
   * @return
   */
  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }

  private int maxGain(TreeNode node) {
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

  int res = 0;

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final TreeNode left = root.left;
    if (left != null) {
      if (left.left == null && left.right == null) {
        res += left.val;
      }
    }
    sumOfLeftLeaves(root.left);
    sumOfLeftLeaves(root.right);

    return res;
  }

}
