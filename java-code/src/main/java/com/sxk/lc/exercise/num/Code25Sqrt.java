package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code25Sqrt {

  public static void main(String[] args) {

    System.out.println(mySqrt(26));
  }

  /**
   * 69. x 的平方根
   * https://leetcode-cn.com/problems/sqrtx/
   *
   * @param x
   * @return
   */
  public static int mySqrt(int x) {
    int left = 0;
    int right = x;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if ((long) mid * mid == x) {
        return mid;
      }
      if ((long) mid * mid < x) {
        left = mid + 1;
        ans = mid;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }

}
