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

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
      xStack = new LinkedList<>();
      minStack = new LinkedList<>();
      minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
      xStack.push(val);
      minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
      xStack.pop();
      minStack.pop();
    }

    public int top() {
      return xStack.peek();
    }

    public int getMin() {
      return minStack.peek();
    }
  }

}
