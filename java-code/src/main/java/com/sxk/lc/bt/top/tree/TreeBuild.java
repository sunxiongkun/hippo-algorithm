package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class TreeBuild {


  public static void main(String[] args) {

  }

  static Map<Integer, Integer> inMap = new HashMap<>();

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = inorder.length;
    for (int i = 0; i < n; i++) {
      inMap.put(inorder[i], i);
    }
    return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }

  public static TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight,
      int inLeft, int inRight) {
    if (preLeft > preRight) {
      return null;
    }
    int rootVal = preorder[preLeft];
    TreeNode root = new TreeNode(rootVal);
    int rootInOrderIndex = inMap.get(rootVal);
    int leftSubTreeSize = rootInOrderIndex - inLeft;

    root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftSubTreeSize, inLeft,
        rootInOrderIndex - 1);
    root.right = buildTree(preorder, inorder, preLeft + leftSubTreeSize + 1, preRight,
        rootInOrderIndex + 1,
        inRight);
    return root;

  }
}
