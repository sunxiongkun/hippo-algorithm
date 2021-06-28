package com.sxk.lc.middle;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sxk
 */
public class Rand5ToRand7 {

  public static void main(String[] args) {

  }


  /***
   * 二进制
   * 要求等概率返回1～7
   */
  public static int rand7() {
    int res;
    do {
      res = (rand1() << 2) + (rand1() << 1) + rand1();
    } while (res == 7);
    return res + 1;
  }

  /**
   * 等概率返回 0和1
   */
  public static int rand1() {
    int res;
    do {
      res = rand5();
    } while (res == 3);
    return res < 3 ? 0 : 1;
  }

  /**
   * 等概率返回1～5
   *
   * @return
   */
  public static int rand5() {
    return ThreadLocalRandom.current().nextInt(1, 6);
  }

}
