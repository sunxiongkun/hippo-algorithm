package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code43AddString {

  public static void main(String[] args) {

    System.out.println(addStrings("1", "9"));
  }

  /**
   * 415. 字符串相加
   * https://leetcode-cn.com/problems/add-strings/
   *
   * @param num1
   * @param num2
   * @return
   */
  public static String addStrings(String num1, String num2) {
    char[] char1 = num1.toCharArray();
    char[] char2 = num2.toCharArray();
    int moreNum = 0;
    int idx1 = char1.length - 1;
    int idx2 = char2.length - 1;
    StringBuilder sb = new StringBuilder();
    while (idx1 >= 0 || idx2 >= 0) {
      int n1 = idx1 >= 0 ? char1[idx1] - '0' : 0;
      int n2 = idx2 >= 0 ? char2[idx2] - '0' : 0;
      int sum = n1 + n2 + moreNum;
      moreNum = sum / 10;
      sb.append(sum % 10);
      idx1--;
      idx2--;
    }
    if (moreNum != 0) {
      sb.append(moreNum);
    }
    sb.reverse();
    return sb.toString();
  }
}
