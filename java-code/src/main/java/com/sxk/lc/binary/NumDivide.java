package com.sxk.lc.binary;

/**
 * @author sxk
 * @date 2021/4/21 9:21 上午
 */
public class NumDivide {

  public static void main(String[] args) {
    System.out.println(div(10, 3));
  }


  /***
   * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
   * https://leetcode-cn.com/problems/divide-two-integers/
   * @param dividend
   * @param divisor
   * @return
   */
  public int divide(int dividend, int divisor) {

    return -1;
  }

  static int div(int a, int b) {  // 似乎精髓和难点就在于下面这几句
    if (a < b) {
      return 0;
    }
    int count = 1;
    int temp = b;
    while ((temp + temp) <= a) {
      // 最小解翻倍
      count = count + count;
      // 当前测试的值也翻倍
      temp = temp + temp;
    }
    return count + div(a - temp, b);
  }

}
