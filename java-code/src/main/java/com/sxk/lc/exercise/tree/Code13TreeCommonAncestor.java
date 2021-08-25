package com.sxk.lc.exercise.tree;

import com.sxk.entity.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sxk
 */
public class Code13TreeCommonAncestor {

  public static void main(String[] args) {

  }


  /**
   * 236. 二叉树的最近公共祖先
   * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    parentMap.put(root, null);
    childParent(parentMap, root);
    Set<TreeNode> parentSet = new HashSet<>();
    TreeNode cur = p;
    parentSet.add(cur);
    while (parentMap.get(cur) != null) {
      cur = parentMap.get(cur);
      parentSet.add(cur);
    }
    cur = q;
    while (!parentSet.contains(cur)) {
      cur = parentMap.get(cur);
    }
    return cur;
  }

  public void childParent(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
    if (root.left != null) {
      parentMap.put(root.left, root);
      childParent(parentMap, root.left);
    }
    if (root.right != null) {
      parentMap.put(root.right, root);
      childParent(parentMap, root.right);
    }
  }


}
