package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/4/18 10:31 上午
 */
public class TreeDistance {

  public static void main(String[] args) {
    final TreeNode root = BasicTree.createLeftFullBinaryTree();
    System.out.println(maxDistance(root));
  }

  private static class DistanceInfo {

    private int distance;
    private int height;

    public DistanceInfo(int distance, int height) {
      this.distance = distance;
      this.height = height;
    }
  }

  /**
   * 最大距离
   *
   * @param root
   * @return
   */
  public static int maxDistance(TreeNode root) {
    return maxDistanceInfo(root).distance;
  }

  public static DistanceInfo maxDistanceInfo(TreeNode root) {
    if (root == null) {
      return new DistanceInfo(0, 0);
    }

    final DistanceInfo leftInfo = maxDistanceInfo(root.left);
    final DistanceInfo rightInfo = maxDistanceInfo(root.right);
    int maxHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
    int maxDistance = Math.max(Math.max(leftInfo.distance, rightInfo.distance),
        leftInfo.distance + rightInfo.distance + 1);

    return new DistanceInfo(maxDistance, maxHeight);
  }

}
