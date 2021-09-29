package com.sxk.lc.exercise.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sxk
 */
public class Code49MinStack {


  /**
   * 155. 最小栈
   * https://leetcode-cn.com/problems/min-stack/
   */
  private class MinStack {

    Deque<Node> dataStack;

    public MinStack() {
      dataStack = new LinkedList<>();
    }

    public void push(int val) {
      Node node;
      if (dataStack.isEmpty()) {
        node = new Node(val, val);
      } else {
        node = new Node(val, Math.min(dataStack.peek().min, val));
      }
      dataStack.push(node);
    }

    public void pop() {
      dataStack.pop();
    }

    public int top() {
      return dataStack.peek().val;
    }

    public int getMin() {
      return dataStack.peek().min;
    }

    private class Node {

      private int val;
      private int min;

      public Node(int val, int min) {
        this.val = val;
        this.min = min;
      }
    }
  }

}
