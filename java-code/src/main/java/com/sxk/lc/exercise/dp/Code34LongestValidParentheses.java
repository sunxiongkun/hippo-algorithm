package com.sxk.lc.exercise.dp;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author sxk
 */
public class Code34LongestValidParentheses {

  public static void main(String[] args) {
    String str = "(()))";
    System.out.println(longestValidParentheses(str));
    System.out.println(longestValidParentheses2(str));

    String str1 = "()[]{}";
    String str2 = "{[]}";
    String str3 = "([)]";
    System.out.println(isValid(str1));
    System.out.println(isValid(str2));
    System.out.println(isValid(str3));

    System.out.println("==============");
    System.out.println(isValid2(str1));
    System.out.println(isValid2(str2));
    System.out.println(isValid2(str3));
  }

  /**
   * 32. 最长有效括号
   * https://leetcode-cn.com/problems/longest-valid-parentheses/
   * 时间：O(n)
   * 空间 ：O(n)
   *
   * @param str
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

  /**
   * 20. 有效的括号
   * https://leetcode-cn.com/problems/valid-parentheses/
   *
   * @param s
   * @return
   */
  public static boolean isValid(String s) {
    char[] array = s.toCharArray();
    if (array.length % 2 == 1) {
      return false;
    }
    int count1 = 0, count2 = 0, count3 = 0;
    for (char c : array) {
      if (count1 < 0 || count2 < 0 || count3 < 0) {
        return false;
      }
      switch (c) {
        case '(':
          count1++;
          break;
        case '{':
          count2++;
          break;
        case '[':
          count3++;
          break;
        case ')':
          count1--;
          break;
        case '}':
          count2--;
          break;
        case ']':
          count3--;
          break;
        default:
          return false;
      }
    }
    return count1 == 0 && count2 == 0 && count3 == 0;
  }

  public static boolean isValid2(String s) {
    char[] array = s.toCharArray();
    int n = array.length;
    if (n % 2 == 1) {
      return false;
    }

    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
      put(')', '(');
      put(']', '[');
      put('}', '{');
    }};
    Deque<Character> stack = new LinkedList<>();
    for (char ch : array) {
      if (pairs.containsKey(ch)) {
        if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
          return false;
        }
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }


}
