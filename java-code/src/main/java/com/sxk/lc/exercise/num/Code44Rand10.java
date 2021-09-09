package com.sxk.lc.exercise.num;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sxk
 */
public class Code44Rand10 {


  public static void main(String[] args) {
    int num0 = 0;
    int num1 = 0;
    for (int i = 0; i < 100; i++) {
      int res = rand10();
      System.out.println(res);
      if (res < 6) {
        num0++;
      }
      if (res > 5) {
        num1++;
      }
    }
    System.out.println(num0);
    System.out.println(num1);
  }

  public static int rand7() {
    return ThreadLocalRandom.current().nextInt(1, 8);
  }

  /**
   * 等概率返回 0 和 1
   *
   * @return
   */


  /**
   * 470. 用 Rand7() 实现 Rand10()
   * https://leetcode-cn.com/problems/implement-rand10-using-rand7/
   *
   * @return
   */
  public static int rand10() {
    int res;
    do {
      res = (rand7() << 2) + (rand1() << 2) + rand1();
    } while (res == 10);
    return res + 1;
  }

  public static int rand1() {
    int res;
    do {
      res = rand7();
    } while (res == 4);
    return res < 4 ? 0 : 1;
  }
}
