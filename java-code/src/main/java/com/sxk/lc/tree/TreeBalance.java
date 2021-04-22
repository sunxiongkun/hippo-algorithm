package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;
import lombok.Data;

/**
 * @author sxk
 * @date 2021/3/23 4:50 下午
 */
public class TreeBalance extends BasicTree {

  public static void main(String[] args) {
    TreeNode root = createFullBinaryTree();
    System.out.println(isBalance(root));
  }

  @Data
  static class BalanceInfo {

    private boolean isBalance;
    private int height;

    public BalanceInfo(boolean isBalance, int height) {
      this.isBalance = isBalance;
      this.height = height;
    }

  }

  /***
   *
   * 判断是否是平衡二叉树
   * https://leetcode-cn.com/problems/check-balance-lcci/
   *
   * @param root
   * @return
   */
  public static boolean isBalance(TreeNode root) {
    return getBalanceInfo(root, 1).isBalance;
  }

  public static BalanceInfo getBalanceInfo(TreeNode root, int height) {
    if (root == null) {
      return new BalanceInfo(true, 0);
    }

    final BalanceInfo leftBalance = getBalanceInfo(root.left, height + 1);
    final BalanceInfo rightBalance = getBalanceInfo(root.right, height + 1);
    int newHeight = Math.max(leftBalance.height, rightBalance.height) + 1;
    boolean isBalance = false;
    if (leftBalance.isBalance && rightBalance.isBalance
        && Math.abs(leftBalance.height - rightBalance.height) < 2) {
      isBalance = true;
    }
    return new BalanceInfo(isBalance, newHeight);
  }


}
