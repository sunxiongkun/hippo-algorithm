package com.sxk.lc.tree;

/**
 * @author sxk
 * @date 2021/3/23 2:05 下午
 */
public class TreeFill {

  public static void main(String[] args) {

  }

  public Node fillNode(Node root) {
    if (root == null) {
      return null;
    }
    fillNode(root.left, root.right);
    return root;
  }

  public void fillNode(Node node1, Node node2) {
    if (node1 == null || node2 == null) {
      return;
    }
    node1.next = node2;
    fillNode(node1.left, node1.right);
    fillNode(node2.left, node2.right);
    fillNode(node1.right, node2.left);
  }

  static class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}


