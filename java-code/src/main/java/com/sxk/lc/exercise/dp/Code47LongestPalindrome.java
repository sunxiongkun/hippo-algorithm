package com.sxk.lc.exercise.dp;

/**
 * @author sxk
 */
public class Code47LongestPalindrome {

  public static void main(String[] args) {

  }

  /**
   * 5. 最长回文子串
   * https://leetcode-cn.com/problems/longest-palindromic-substring/
   * 时间：O(n^2)
   * 空间：O(n^2)
   * @param s
   * @return
   */
  public static String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    if (len == 1) {
      return s;
    }
    int begin = 0;
    int maxLen = 1;
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }
    for (int l = len - 2; l >= 0; l--) {
      for (int r = l + 1; r < len; r++) {
        if (l + 1 == r) {
          dp[l][r] = chars[l] == chars[r];
        } else {
          if (chars[l] == chars[r]) {
            if (l + 2 == r) {
              dp[l][r] = true;
            } else {
              dp[l][r] = dp[l + 1][r - 1];
            }
          } else {
            dp[l][r] = false;
          }
        }
        if (dp[l][r] && maxLen < (r - l + 1)) {
          maxLen = r - l + 1;
          begin = l;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

}
