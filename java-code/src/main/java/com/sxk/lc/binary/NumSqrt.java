package com.sxk.lc.binary;

/**
 * @author sxk
 * @date 2021/4/22 10:34 上午
 */
public class NumSqrt {

  public static void main(String[] args) {
    final double res = Math.sqrt(4);
    System.out.println(res);
    System.out.println(mySqrt(4));
    System.out.println(mySqrt(16));
    System.out.println(mySqrt(25));
    System.out.println(mySqrt(2147395599));
    System.out.println(Integer.MAX_VALUE);
  }

  /***
   * 平方根
   * https://leetcode-cn.com/problems/sqrtx/
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
