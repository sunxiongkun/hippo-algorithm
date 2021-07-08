package com.sxk.lc.bt.top.tree;

import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sxk
 */
public class TreeSerializable {

  static String nullNode = "#";

  public static void main(String[] args) {
    TreeNode root = BasicTree.createFullBinaryTree();
    String str = serialize(root);
    System.out.println(str);
    System.out.println(deserialize(str));
  }


  public static String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString().replaceFirst(",", "");
  }

  public static void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append(",");
      sb.append(nullNode);
      return;
    }
    sb.append(",");
    sb.append(root.val);
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  public static TreeNode deserialize(String data) {
    String[] split = data.split(",");
    Queue<String> queue = new LinkedList<>(Arrays.asList(split));
    return deserialize(queue);
  }

  public static TreeNode deserialize(Queue<String> queue) {
    String poll = queue.poll();
    if (poll == null || nullNode.equals(poll)) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(poll));
    root.left = deserialize(queue);
    root.right = deserialize(queue);
    return root;
  }


}
