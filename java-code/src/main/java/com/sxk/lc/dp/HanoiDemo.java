package com.sxk.lc.dp;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sxk
 * @date 2021/4/22 8:59 下午
 */
@Slf4j
public class HanoiDemo {

  public static void main(String[] args) {
    moveHanoi(3, "left", "right", "middle");
  }

  /**
   * 汉若塔打印
   *
   * @param n
   * @param from
   * @param to
   * @param other
   */
  public static void moveHanoi(int n, String from, String to, String other) {
    if (n == 1) {
      System.out.println(String.format("move 1 from %s to %s", from, to));
    } else {
      moveHanoi(n - 1, from, other, to);
      System.out.println(String.format("move %s from %s to %s", n, from, to));
      moveHanoi(n - 1, other, to, from);
    }
  }

}
