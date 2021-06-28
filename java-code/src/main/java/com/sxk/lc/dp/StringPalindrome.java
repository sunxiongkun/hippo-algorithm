package com.sxk.lc.dp;

/**
 * @author sxk
 * @date 2021/3/27 3:50 下午
 */
public class StringPalindrome {

  public static void main(String[] args) {
    String str = "abccbd";
    System.out.println(lpsl1(str));
    System.out.println(lpsl2(str));
    System.out.println(longestPalindrome(str));
  }


  public static int lpsl1(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    char[] str = s.toCharArray();
    return f(str, 0, str.length - 1);
  }

  // str[L..R]最长回文子序列长度返回
  public static int f(char[] str, int L, int R) {
    if (L == R) {
      return 1;
    }
    if (L == R - 1) {
      return str[L] == str[R] ? 2 : 1;
    }
    int p1 = f(str, L + 1, R - 1);
    int p2 = f(str, L, R - 1);
    int p3 = f(str, L + 1, R);
    int p4 = str[L] != str[R] ? 0 : (2 + f(str, L + 1, R - 1));
    return Math.max(Math.max(p1, p2), Math.max(p3, p4));
  }

  public static int lpsl2(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    char[] str = s.toCharArray();
    int N = str.length;
    int[][] dp = new int[N][N];
    dp[N - 1][N - 1] = 1;
    for (int i = 0; i < N - 1; i++) {
      dp[i][i] = 1;
      dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
    }
    for (int L = N - 3; L >= 0; L--) {
      for (int R = L + 2; R < N; R++) {
        dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
        if (str[L] == str[R]) {
          dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
        }
      }
    }
    return dp[0][N - 1];
  }

  /***
   * 最长回文子串  正反读取都一样 对称
   * https://leetcode-cn.com/problems/longest-palindromic-substring/
   *
   * @param s
   * @return
   */
  public static String longestPalindrome(String s) {
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
        if (dp[i][j] && l + i > res.length()) {
          res = s.substring(i, i + l + 1);
        }
      }
    }
    return res;
  }


}
