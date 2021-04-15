package com.sxk.lc.dp;

/**
 * @author sxk
 * @date 2021/3/27 3:50 下午
 */
public class StringDp {

  public static void main(String[] args) {

  }

  /***
   * 最长回文子串  正反读取都一样 对称
   * https://leetcode-cn.com/problems/longest-palindromic-substring/
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    int length = s.length();
    String res = "";
    boolean[][] dp = new boolean[length][length];
    for (int l = 0; l < length; l++) {
      for (int i = 0; i + l < length; i++) {
        int j = i + 1;
        if (l == 0) {
          dp[i][j] = true;
        } else if (l == 1) {
          dp[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
        }
        if (dp[i][j] && l + 1 > res.length()) {
          res = s.substring(i, i + l + 1);
        }
      }
    }
    return res;
  }

}
