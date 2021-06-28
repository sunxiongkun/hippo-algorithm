package com.sxk.lc.middle;

/**
 * @author sxk
 */
public class AppleMinBags {

  public static int minBags(int apple) {
    if (apple < 0) {
      return -1;
    }
    int bag8 = (apple >> 3);
    int rest = apple - (bag8 << 3);
    //24 是6和8的最小公倍数
    while (bag8 >= 0 && rest < 24) {
      // rest 个
      if (rest % 6 == 0) {
        return bag8 + (rest / 6);
      } else {
        bag8--;
        rest += 8;
      }
    }
    return -1;
  }

  /**
   * 打表法(根据数学规律 可以解决4成算法题) 就是最优解
   *
   * @param apple
   * @return
   */
  public static int minBagAwesome(int apple) {
    if ((apple & 1) != 0) { // 如果是奇数，返回-1
      return -1;
    }
    if (apple < 18) {
      return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
          : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
    }
    return (apple - 18) / 8 + 3;
  }

  public static void main(String[] args) {
    for (int apple = 1; apple < 200; apple++) {
      System.out.println(apple + " : " + minBags(apple));
    }

  }
}
