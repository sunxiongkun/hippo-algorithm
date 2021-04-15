package com.sxk.lc.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sxk
 * @date 2021/3/23 6:35 下午
 */
public class NTree {

  static class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }


  public static void main(String[] args) {
    Node root = new Node(1);
    Node root1 = new Node(2);
    Node root2 = new Node(3);
    List<Node> child = new ArrayList<>();
    child.add(root1);
    child.add(root2);
    root.children = child;
    System.out.println(new NTree().levelOrder(root));
  }

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      final int qz = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < qz; i++) {
        final Node cur = queue.poll();
        level.add(cur.val);
        if (cur.children==null) {
          continue;
        }
        for (Node children : cur.children) {
          queue.offer(children);
        }
      }
      ret.add(level);
    }
    return ret;
  }




}


