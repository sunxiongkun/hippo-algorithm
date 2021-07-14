package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 */
public class TreeKthSmallest {


  public static void main(String[] args) {

  }

  /**
   * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
   *
   * @param root
   * @param k
   * @return
   */
  static int rank;

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return 0;
    }
    kthSmallest(root.left, k);
    if (rank == k) {
      return root.val;
    }
    rank++;
    kthSmallest(root.right, k);
    return 0;
  }


}
