package com.sxk.lc.top100;

/**
 * @author sxk
 * @date 2021/5/11 8:54 下午
 */
public class LongestPalindrome {

  public static void main(String[] args) {
    String str = "abcxcby";
    System.out.println(longestPalindrome(str));

  }

  /***
   *  动态规划
   *  https://leetcode-cn.com/problems/longest-palindromic-substring/
   *
   * @param s
   * @return
   */
  public static String longestPalindrome(String s) {
    final char[] arr = s.toCharArray();
    return process(arr, 0, arr.length - 1);
  }

  public static String process(char[] arr, int l, int r) {
    if (l == r) {
      return String.valueOf(arr[l]);
    }

    final String leftStr = process(arr, l, r - 1);
    final String rightStr = process(arr, l + 1, r);
    if (arr[l] == arr[r]) {
      return leftStr + arr[l];
    }
    return leftStr.length() > rightStr.length() ? leftStr : rightStr;

  }


}
