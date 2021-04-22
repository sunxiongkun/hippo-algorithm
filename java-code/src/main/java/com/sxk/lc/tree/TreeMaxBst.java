package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/4/18 5:44 下午
 */
public class TreeMaxBst {

  public static void main(String[] args) {
    final TreeSerialize test = new TreeSerialize();
    //final TreeNode root = test.preDeserialize("4,3,1,#,#,2,#,#,#");
    final TreeNode root = test.preDeserialize("-4,-2,#,#,-5,#,#");
    System.out.println(test.preSerialize(root));
    System.out.println(new TreeMaxBst().maxSumBST(root));

  }


  /***
   * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和
   * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
   * @param root
   * @return
   */

  public int maxSumBST(TreeNode root) {
    return getMaxSumBST(root).maxSumBstValue;
  }

  private static class MaxSumInfo {

    private boolean isAllBst;
    private int minValue;
    private int maxValue;
    private int maxSumBstValue;

    public MaxSumInfo(boolean isAllBst, int minValue, int maxValue, int maxSumBstValue) {
      this.isAllBst = isAllBst;
      this.minValue = minValue;
      this.maxValue = maxValue;
      this.maxSumBstValue = maxSumBstValue;
    }
  }

  public MaxSumInfo getMaxSumBST(TreeNode root) {
    if (root == null) {
      return null;
    }
    final MaxSumInfo leftInfo = getMaxSumBST(root.left);
    final MaxSumInfo rightInfo = getMaxSumBST(root.right);
    int minValue = root.val;
    int maxValue = root.val;
    if (leftInfo != null) {
      minValue = Math.min(minValue, leftInfo.minValue);
      maxValue = Math.max(maxValue, leftInfo.maxValue);
    }
    if (rightInfo != null) {
      minValue = Math.min(minValue, rightInfo.minValue);
      maxValue = Math.max(maxValue, rightInfo.maxValue);
    }
    int maxSumBstValue = root.val;
    if (leftInfo != null) {
      maxSumBstValue = leftInfo.maxSumBstValue;
    }
    if (rightInfo != null) {
      maxSumBstValue = Math.max(maxSumBstValue, rightInfo.maxSumBstValue);
    }
    maxSumBstValue = Math.max(maxSumBstValue, 0);
    boolean isAllBst = false;
    if (
        (leftInfo == null ? true : leftInfo.isAllBst)
            && (rightInfo == null ? true : rightInfo.isAllBst)
            && (leftInfo == null ? true : leftInfo.maxValue < root.val)
            && (rightInfo == null ? true : rightInfo.minValue > root.val)
    ) {

      maxSumBstValue = (leftInfo == null ? 0 : leftInfo.maxSumBstValue)
          + (rightInfo == null ? 0 : rightInfo.maxSumBstValue)
          + root.val;
      isAllBst = true;
    }

    return new MaxSumInfo(isAllBst, minValue, maxValue, maxSumBstValue);

  }

}
