package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author sxk
 * @date 2021/3/23 4:50 下午
 */
public class TreePath extends BasicTree {

  public static void main(String[] args) {
    TreeNode root = createFullBinaryTree();
    System.out.println(new TreePath().sumNumbers(root));

    System.out.println(new TreePath().binaryTreePaths(root));

  }


  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ret = new ArrayList<>();
    binaryTreePath(root, null, ret);
    return ret;
  }

  public void binaryTreePath(TreeNode root, String path, List<String> ret) {
    if (root != null) {
      StringJoiner sj = new StringJoiner("->");
      if (path != null) {
        sj.add(path);
      }
      sj.add(String.valueOf(root.val));
      path = sj.toString();
      if (root.left == null && root.right == null) {
        ret.add(path);
      } else {
        binaryTreePath(root.left, path, ret);
        binaryTreePath(root.right, path, ret);
      }
    }
  }


  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
        targetSum - root.val);

  }

  List<List<Integer>> ret = new LinkedList<>();
  Deque<Integer> path = new LinkedList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    dfsSum(root, sum);
    return ret;
  }

  public void dfsSum(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    path.offerLast(root.val);
    sum -= root.val;
    if (root.left == null && root.right == null && sum == 0) {
      ret.add(new LinkedList<>(path));
    }
    dfsSum(root.left, sum);
    dfsSum(root.right, sum);
    path.pollLast();
  }

  /**
   * 求根节点到叶节点数字之和
   * 129 -> https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
   *
   * @param root
   * @return
   */
  public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }

  public int dfs(TreeNode root, int prevSum) {
    if (root == null) {
      return 0;
    }
    int sum = prevSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      return sum;
    } else {
      return dfs(root.left, sum) + dfs(root.right, sum);
    }
  }


}
