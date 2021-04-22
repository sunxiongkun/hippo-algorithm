package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sxk
 * @date 2021/4/22 6:43 下午
 */
public class CommonAncestor {

  public static void main(String[] args) {

  }

  /***
   * 最近公共祖先
   * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
   *
   * @param root
   * @param p
   * @param q
   * @return
   */

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

  public AncestorInfo process(TreeNode root, TreeNode p, TreeNode q) {
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


  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    final Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    parentMap.put(root, null);
    fillParentMap(root, parentMap);
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

  public void fillParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
    if (root.left != null) {
      parentMap.put(root.left, root);
      fillParentMap(root.left, parentMap);
    }
    if (root.right != null) {
      parentMap.put(root.right, root);
      fillParentMap(root.right, parentMap);
    }
  }

}
