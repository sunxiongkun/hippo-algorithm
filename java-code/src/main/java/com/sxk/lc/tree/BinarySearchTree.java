package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;

/**
 * @author sxk
 * @date 2021/3/25 6:09 下午
 */
public class BinarySearchTree extends BasicTree {

  public static void main(String[] args) {
    TreeNode root = createBinarySearchTree();
    final boolean validBST = new BinarySearchTree().isValidBST(root);
    System.out.println(validBST);

    System.out.println(new BinarySearchTree().kthSmallest(root, 2));


  }

  long pre = Long.MIN_VALUE;

  /**
   * 是否是二叉搜索树
   *
   * @param root
   * @return
   */
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 访问左子树
    if (!isValidBST(root.left)) {
      return false;
    }
    // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
    if (root.val <= pre) {
      return false;
    }
    pre = root.val;
    // 访问右子树
    return isValidBST(root.right);
  }

  /**
   * 1 <= k <= n
   *
   * @param root
   * @param k
   * @return
   */
  public int kthSmallest(TreeNode root, int k) {
    nodeRank(root, k);
    return res;
  }

  // 记录结果
  int res = 0;
  // 记录当前元素的排名
  int rank = 0;

  public void nodeRank(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    nodeRank(root.left, k);
    /* 中序遍历代码位置 */
    rank++;
    if (k == rank) {
      // 找到第 k 小的元素
      res = root.val;
      return;
    }
    nodeRank(root.right, k);
  }

  /**
   * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
   *
   * @param root
   * @return
   */

  public TreeNode convertBST(TreeNode root) {
    inOrderReverse(root);
    return root;
  }

  int sum = 0;

  /***
   *
   * 中序遍历是升序 left->o->right
   * right->o->left 中序反转是降序
   *
   * @param root
   */
  public void inOrderReverse(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrderReverse(root.right);
    sum += root.val;
    root.val = sum;
    inOrderReverse(root.left);
  }

}
