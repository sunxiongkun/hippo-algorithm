package com.sxk.lc.middle;

/**
 * @author sxk
 */
public class NeedParentheses {


  public static void main(String[] args) {
    String s = "((())";
    System.out.println(needParentheses(s));
    System.out.println(maxParenthesesLength(s));
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

  /***
   * 有效括号的长度
   * (()())()()
   * @param str
   * @return
   */
  public static int maxParenthesesLength(String str) {
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
}
