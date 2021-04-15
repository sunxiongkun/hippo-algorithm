package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 * @date 2021/3/17 3:17 下午
 */
public class BuildTree extends BasicTree {

  public static void main(String[] args) {
    int[] preOrder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
    int[] inOrder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
    final TreeNode root = new BuildTree().buildTree(preOrder, inOrder);
    System.out.println(root);
  }

  private Map<Integer, Integer> indexMap;

  public TreeNode myBuildTree(int[] preOrder, int[] inOrder, int preorderLeft, int preorderRight,
      int inorderLeft, int inorderRight) {
    if (preorderLeft > preorderRight) {
      return null;
    }

    // 前序遍历中的第一个节点就是根节点
    int preOrderRoot = preorderLeft;
    // 在中序遍历中定位根节点
    int inOrderRoot = indexMap.get(preOrder[preOrderRoot]);

    // 先把根节点建立出来
    TreeNode root = new TreeNode(preOrder[preOrderRoot]);
    // 得到左子树中的节点数目
    int sizeLeftSubTree = inOrderRoot - inorderLeft;
    // 递归地构造左子树，并连接到根节点
    // 先序遍历中「从 左边界+1 开始的 sizeLeftSubTree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
    root.left = myBuildTree(preOrder, inOrder, preorderLeft + 1, preorderLeft + sizeLeftSubTree,
        inorderLeft, inOrderRoot - 1);
    // 递归地构造右子树，并连接到根节点
    // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
    root.right = myBuildTree(preOrder, inOrder, preorderLeft + sizeLeftSubTree + 1,
        preorderRight, inOrderRoot + 1, inorderRight);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    // 构造哈希映射，帮助我们快速定位根节点
    indexMap = new HashMap<>(16);
    for (int i = 0; i < n; i++) {
      indexMap.put(inorder[i], i);
    }
    return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }


}
