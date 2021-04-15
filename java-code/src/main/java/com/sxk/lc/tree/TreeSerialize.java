package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * @author sxk
 * @date 2021/3/29 6:38 下午
 */
public class TreeSerialize extends BasicTree {

  static final String SPLIT = ",";
  static final String NULL_NODE = "#";

  public static void main(String[] args) {
    final TreeNode root = createFullBinaryTree();
    final TreeSerialize test = new TreeSerialize();
    final String data = test.preSerialize(root);
    System.out.println(data);

    final TreeNode newRoot = test.preDeserialize(data);
    System.out.println(test.preSerialize(newRoot));

  }

  /**
   * 把一棵二叉树序列化成字符串
   *
   * @param root
   * @return
   */
  public String preSerialize(TreeNode root) {
    final StringJoiner sj = new StringJoiner(SPLIT);
    preSerialize2(root, sj);
    return sj.toString();
  }

  public void preSerialize2(TreeNode root, StringJoiner sj) {
    if (root == null) {
      sj.add(NULL_NODE);
      return;
    }
    sj.add(String.valueOf(root.val));
    preSerialize2(root.left, sj);
    preSerialize2(root.right, sj);
  }

  /**
   * 把字符串反序列化成二叉树
   *
   * @param data
   * @return
   */
  public TreeNode preDeserialize(String data) {
    LinkedList<String> nodes = new LinkedList<>();
    for (String s : data.split(SPLIT)) {
      nodes.addLast(s);
    }
    return preDeserialize(nodes);
  }

  /**
   * 辅助函数，通过 nodes 列表构造二叉树
   */
  TreeNode preDeserialize(LinkedList<String> nodes) {
    if (nodes.isEmpty()) {
      return null;
    }

    /****** 前序遍历位置 ******/
    // 列表最左侧就是根节点
    String first = nodes.removeFirst();
    if (first.equals(NULL_NODE)) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(first));

    root.left = preDeserialize(nodes);
    root.right = preDeserialize(nodes);

    return root;
  }

}
