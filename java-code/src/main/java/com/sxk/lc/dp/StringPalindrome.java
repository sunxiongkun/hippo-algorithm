package com.sxk.lc.dp;

/**
 * @author sxk
 * @date 2021/3/27 3:50 下午
 */
public class StringPalindrome {

  public static void main(String[] args) {
    String str = "abccbd";
    //String str = "cbbd";
    //String str = "ab";
    System.out.println(lpsl1(str));
    System.out.println(lpsl2(str));
    System.out.println(longestPalindrome(str));
    System.out.println(longestPalindrome2(str));
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
  public static String longestPalindrome2(String s) {
    int length = s.length();
    if (length < 2) {
      return s;
    }
    int maxLen = 1;
    int begin = 0;
    char[] charArray = s.toCharArray();
    boolean[][] dp = new boolean[length][length];
    for (int i = 0; i < length - 1; i++) {
      dp[i][i] = true;
    }
    for (int l = length - 2; l >= 0; l--) {
      for (int r = l + 1; r < length; r++) {
        if (r == l + 1) {
          dp[l][r] = charArray[l] == charArray[r];
        } else {
          if (charArray[l] == charArray[r]) {
            if (l + 2 == r) {
              dp[l][r] = true;
            } else {
              dp[l][r] = dp[l + 1][r - 1];
            }
          } else {
            dp[l][r] = false;
          }
        }
        if (dp[l][r] && (r - l + 1) > maxLen) {
          maxLen = r - l + 1;
          begin = l;
        }
      }
    }

    return s.substring(begin, begin + maxLen);
  }

  public static String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }

    int maxLen = 1;
    int begin = 0;
    // dp[i][j] 表示 s[i..j] 是否是回文串
    boolean[][] dp = new boolean[len][len];
    // 初始化：所有长度为 1 的子串都是回文串
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    char[] charArray = s.toCharArray();
    // 递推开始
    // 先枚举子串长度
    for (int L = 2; L <= len; L++) {
      // 枚举左边界，左边界的上限设置可以宽松一些
      for (int i = 0; i < len; i++) {
        // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
        int j = L + i - 1;
        // 如果右边界越界，就可以退出当前循环
        if (j >= len) {
          break;
        }

        if (charArray[i] != charArray[j]) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
        if (dp[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }


}
