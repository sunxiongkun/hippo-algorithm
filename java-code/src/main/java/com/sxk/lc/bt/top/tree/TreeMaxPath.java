package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sxk
 */
public class TreeMaxPath {

  public static void main(String[] args) {

  }

  /**
   * 最大路径和
   * 124-> https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
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

  /**
   * 剑指 Offer 34. 二叉树中和为某一值的路径
   * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
   *
   * @param root
   * @param target
   * @return
   */

  List<List<Integer>> ret = new LinkedList<>();
  Deque<Integer> path = new LinkedList<>();

  public List<List<Integer>> pathSum(TreeNode root, int target) {
    dfs(root, target);
    return ret;
  }

  public void dfs(TreeNode root, int target) {
    if (root == null) {
      return;
    }
    path.offerLast(root.val);
    target -= root.val;
    if (root.left == null && root.right == null && target == 0) {
      ret.add(new LinkedList<>(path));
    }
    dfs(root.left, target);
    dfs(root.right, target);
    path.pollLast();
  }


  /**
   * 路径总和
   * 112 -> https://leetcode-cn.com/problems/path-sum/
   *
   * @param root
   * @param targetSum
   * @return
   */
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
        targetSum - root.val);
  }

}
