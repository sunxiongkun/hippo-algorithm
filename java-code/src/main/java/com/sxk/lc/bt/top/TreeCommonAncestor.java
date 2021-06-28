package com.sxk.lc.bt.top;

import com.sxk.entity.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sxk
 */
public class TreeCommonAncestor {


  public static void main(String[] args) {

  }

  /**
   * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
   */

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) {
      return null;
    }
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    parentMap.put(root, null);
    parentMap(root, parentMap);

    final Set<TreeNode> nodeSet = new HashSet<>();
    TreeNode cur = p;
    nodeSet.add(cur);
    while (parentMap.get(cur) != null) {
      cur = parentMap.get(cur);
      nodeSet.add(cur);
    }
    cur = q;
    while (!nodeSet.contains(cur)) {
      cur = parentMap.get(cur);
    }
    return cur;
  }

  public static void parentMap(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
    if (node.left != null) {
      parentMap.put(node.left, node);
      parentMap(node.left, parentMap);
    }
    if (node.right != null) {
      parentMap.put(node.right, node);
      parentMap(node.right, parentMap);
    }
  }
}
