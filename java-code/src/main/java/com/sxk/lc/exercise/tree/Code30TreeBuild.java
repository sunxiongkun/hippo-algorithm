package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class Code30TreeBuild {

  public static void main(String[] args) {

  }

  /**
   * 105. 从前序与中序遍历序列构造二叉树
   * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
   *
   * @param preorder
   * @param inorder
   * @return
   */
  private Map<Integer, Integer> inMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(inorder[i], i);
    }
    this.inMap = map;
    return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }

  public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft,
      int inRight) {
    if (inLeft > inRight) {
      return null;
    }
    int rootVal = preorder[preLeft];
    Integer inOrderIndex = inMap.get(rootVal);
    int leftTreeSize = inOrderIndex - inLeft;

    TreeNode root = new TreeNode(rootVal);
    root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftTreeSize, inLeft,
        inOrderIndex - 1);
    root.right = buildTree(preorder, inorder, preLeft + leftTreeSize + 1, preRight,
        inOrderIndex + 1, inRight);
    return root;
  }


}
