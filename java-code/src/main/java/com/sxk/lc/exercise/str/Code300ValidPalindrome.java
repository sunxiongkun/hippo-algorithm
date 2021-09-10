package com.sxk.lc.exercise.str;

/**
 * @author sxk
 */
public class Code300ValidPalindrome {

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    s = "OP";
    System.out.println(isPalindrome(s));
  }

  /**
   * 125. 验证回文串
   * https://leetcode-cn.com/problems/valid-palindrome/
   *
   * @param s
   * @return
   */
  public static boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    char[] chars = s.toLowerCase().toCharArray();
    int left = 0;
    int right = chars.length - 1;
    while (left < right) {
      if (!checkLegal(chars[left])) {
        left++;
        continue;
      }
      if (!checkLegal(chars[right])) {
        right--;
        continue;
      }
      if (chars[left] != chars[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static boolean checkLegal(char c) {
    if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
      return true;
    }
    return false;
  }

}
