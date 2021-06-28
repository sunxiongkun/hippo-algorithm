package com.sxk.lc.middle;

/**
 * @author sxk
 */
public class EatGrass {

  /***
   * 牛羊吃草问题，打表法
   * 如果n份草，最终先手赢，返回"先手"
   * 如果n份草，最终后手赢，返回"后手"
   *
   * @param n
   * @return
   */
  public static String whoWin(int n) {
    /**
     * 0  1   2   3   4
     * 后  先  后   先   先
     */
    if (n < 5) {
      return n == 0 || n == 2 ? "后手" : "先手";
    }
    // 进到这个过程里来，当前的先手，先选
    int want = 1;
    while (want <= n) {
      /**
       * n-want 是留给后手吃的草
       * 次过程的后手赢==本过程中的先手
       */
      if (whoWin(n - want).equals("后手")) {
        return "先手";
      }
      //want * 4 之前判断是否整形溢出
      if (want <= (n / 4)) {
        want *= 4;
      } else {
        break;
      }
    }
    //先手尝试了所有吃的份数都没有赢，就是后手赢
    return "后手";
  }

  public static String winner1(int n) {
    if (n < 5) {
      return (n == 0 || n == 2) ? "后手" : "先手";
    }
    int base = 1;
    while (base <= n) {
      if (winner1(n - base).equals("后手")) {
        return "先手";
      }
      if (base > n / 4) { // 防止base*4之后溢出
        break;
      }
      base *= 4;
    }
    return "后手";
  }

  public static String winner2(int n) {
    if (n % 5 == 0 || n % 5 == 2) {
      return "后手";
    } else {
      return "先手";
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 50; i++) {
      System.out.println(i + " : " + whoWin(i));
    }
  }
}
