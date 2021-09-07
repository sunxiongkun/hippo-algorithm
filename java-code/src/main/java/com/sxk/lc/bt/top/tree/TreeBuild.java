package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class TreeBuild {


  public static void main(String[] args) {

  }

  static Map<Integer, Integer> inMap = new HashMap<>();

  /**
   * 105 -> https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
   *
   * @param preorder
   * @param inorder
   * @return
   */
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
        rootInOrderIndex + 1, inRight);
    return root;

  }


  /**
   * 106 -> https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
   *
   * @param inorder
   * @param postorder
   * @return
   */
  public TreeNode buildTree2(int[] inorder, int[] postorder) {
    int n = inorder.length;
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }
    return buildTree2(inorder, postorder, 0, n - 1, 0, n - 1);
  }

  public static TreeNode buildTree2(int[] inorder, int[] postorder, int inLeft, int inRight,
      int postLeft, int postRight) {
    if (inLeft > inRight) {
      return null;
    }
    int rootVal = postorder[postRight];
    Integer rootInorderIndex = inMap.get(rootVal);
    int subSize = rootInorderIndex - inLeft;

    TreeNode root = new TreeNode(rootVal);

    root.left = buildTree2(inorder, postorder, inLeft, rootInorderIndex - 1, postLeft,
        postLeft + subSize - 1);
    root.right = buildTree2(inorder, postorder, rootInorderIndex + 1, inRight,
        postLeft + subSize, postRight - 1);
    return root;
  }


  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    int N = pre.length;
    if (N == 0) {
      return null;
    }
    TreeNode root = new TreeNode(pre[0]);
    if (N == 1) {
      return root;
    }

    int L = 0;
    for (int i = 0; i < N; ++i) {
      if (post[i] == pre[1]) {
        L = i + 1;
      }
    }

    root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),
        Arrays.copyOfRange(post, 0, L));
    root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N),
        Arrays.copyOfRange(post, L, N - 1));
    return root;
  }

}
