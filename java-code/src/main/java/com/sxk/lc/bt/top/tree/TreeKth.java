package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;

/**
 * @author sxk
 */
public class TreeKth {


  public static void main(String[] args) {

    TreeNode root = BasicTree.createBinarySearchTree();

    TreeKth treeKth = new TreeKth();
    System.out.println(treeKth.kthSmallest(root, 2));
    System.out.println(treeKth.kthLargest(root, 2));

  }

  /**
   * 二叉搜索树中第K小的元素
   * 230 -> https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
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
   * 二叉搜索树的第k大节点
   * 剑指 Offer 54 -> https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
   * <p>
   * 中序遍历倒序 就是递减
   *
   * @param root
   * @param k
   * @return
   */

  // 记录结果
  int res1 = 0;
  int rank1 = 0;

  public int kthLargest(TreeNode root, int k) {
    this.rank1 = k;
    nodeRankDesc(root);
    return res1;
  }


  public void nodeRankDesc(TreeNode root) {
    if (root == null || rank1 == 0) {
      return;
    }
    nodeRankDesc(root.right);
    /* 中序遍历代码位置 */
    rank1--;
    if (rank1 == 0) {
      // 找到第 k 小的元素
      res1 = root.val;
      return;
    }
    nodeRankDesc(root.left);
  }

}
