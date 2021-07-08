package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 */
public class ArrayToBst {

  /**
   * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
   *
   * @param nums
   * @return
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    return process(nums, 0, nums.length - 1);
  }

  public TreeNode process(int[] nums, int l, int r) {
    if (l > r) {
      return null;
    }
    int middle = l + (r - l) / 2;
    TreeNode root = new TreeNode(nums[middle]);
    root.left = process(nums, l, middle - 1);
    root.right = process(nums, middle + 1, r);
    return root;
  }

}
