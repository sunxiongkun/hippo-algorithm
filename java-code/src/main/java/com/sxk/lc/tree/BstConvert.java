package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/4/12 7:00 下午
 */
public class BstConvert extends BasicTree {

  public static void main(String[] args) {
    int[] nums = new int[]{2, 4, 6, 8, 9, 10};
    final BstConvert bst = new BstConvert();
    final TreeNode root = bst.sortedArrayToBST(nums);
    System.out.println(root);
  }

  /***
   * 升序数组构造 二叉搜索树
   * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
   * @param nums
   * @return
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = left + (right - left) / 2;
    final TreeNode root = new TreeNode(nums[mid]);
    final TreeNode leftNode = sortedArrayToBST(nums, left, mid - 1);
    final TreeNode rightNode = sortedArrayToBST(nums, mid + 1, right);
    root.left = leftNode;
    root.right = rightNode;
    return root;
  }
}
