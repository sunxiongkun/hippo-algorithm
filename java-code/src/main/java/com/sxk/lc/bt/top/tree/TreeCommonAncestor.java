package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sxk
 */
public class TreeCommonAncestor {


  public static void main(String[] args) {
    TreeNode root = BasicTree.createFullBinaryTree();
    TreeNode commonParent = lowestCommonAncestor(root, root.left.left, root.left.right);
    System.out.println(commonParent.val);

    System.out.println(lowestCommonAncestor2(root, root.left.left, root.left.right).val);


  }

  /**
   * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
   */

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

  public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    return process(root, p, q).ans;

  }


  private static class AncestorInfo {

    private boolean findP;
    private boolean findQ;
    private TreeNode ans;

    public AncestorInfo(boolean findP, boolean findQ, TreeNode ans) {
      this.findP = findP;
      this.findQ = findQ;
      this.ans = ans;
    }
  }

  public static AncestorInfo process(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return new AncestorInfo(false, false, null);
    }
    final AncestorInfo leftInfo = process(root.left, p, q);
    final AncestorInfo rightInfo = process(root.right, p, q);
    boolean findP = root == p || leftInfo.findP || rightInfo.findP;
    boolean findQ = root == q || leftInfo.findQ || rightInfo.findQ;
    TreeNode ans = null;
    if (leftInfo.ans != null) {
      ans = leftInfo.ans;
    } else if (rightInfo.ans != null) {
      ans = rightInfo.ans;
    } else {
      if (findP && findQ) {
        ans = root;
      }
    }
    return new AncestorInfo(findP, findQ, ans);
  }
}
