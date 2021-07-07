package com.sxk.lc.bt.top;

/**
 * @author sxk
 */
public class SqrtSimple {

  public static void main(String[] args) {
    System.out.println(sqrt(8));
  }

  public static int sqrt(int x) {
    int ans = -1;
    int left = 0;
    int right = x;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long res = (long) mid * mid;
      if (res == x) {
        return mid;
      }
      if (res < x) {
        left = mid + 1;
        ans = mid;
      }
      if (res > x) {
        right = mid - 1;
      }
    }
    return ans;
  }

}
