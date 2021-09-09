package com.sxk.lc.exercise.dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sxk
 */
public class Code34LongestValidParentheses {

  public static void main(String[] args) {
    String str = "(()))";
    System.out.println(longestValidParentheses(str));
    System.out.println(longestValidParentheses2(str));
  }

  /**
   * 32. 最长有效括号
   * https://leetcode-cn.com/problems/longest-valid-parentheses/
   * 时间：O(n)
   * 空间 ：O(n)
   *
   * @param s
   * @return
   */
  public static int longestValidParentheses(String str) {
    int maxNum = 0;
    final char[] chars = str.toCharArray();
    int[] dp = new int[str.length()];
    dp[0] = 0;
    int pre = 0;
    for (int i = 1; i < str.length(); i++) {
      if (chars[i] == ')') {
        pre = i - dp[i - 1] - 1;
        if (pre >= 0 && chars[pre] == '(') {
          dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
        }
      }
      maxNum = Math.max(maxNum, dp[i]);
    }
    return maxNum;
  }

  /**
   * 栈
   *
   * @param s
   * @return
   */
  public static int longestValidParentheses2(String s) {
    int maxNum = 0;
    Deque<Integer> stack = new LinkedList<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          maxNum = Math.max(maxNum, i - stack.peek());
        }
      }
    }
    return maxNum;
  }

  /**
   * 需要多少括号
   */
  public static int needParentheses(String str) {
    int count = 0;
    int ans = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        count++;
      } else {
        //遇到右括号
        if (count == 0) {
          ans++;
        } else {
          count--;
        }
      }
    }
    return count + ans;
  }

}
