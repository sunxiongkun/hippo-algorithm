package com.sxk.lc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberRevert {


  /**
   * input:123 output:321
   *
   * input:-123 output:-321
   *
   * input:120 output:21
   *
   * Integer.MIN Integer.MAX
   */
  public static int reverse(int num) {

    int revertNum = 0;
    int moreNum = 0;
    while (num != 0) {
      moreNum = num % 10;
      num = num / 10;
      if (revertNum > Integer.MAX_VALUE / 10 || (revertNum == Integer.MAX_VALUE / 10
          && moreNum > 7)) {
        return 0;
      }

      if (revertNum < Integer.MIN_VALUE / 10 || (revertNum == Integer.MIN_VALUE / 10
          && moreNum < -8)) {
        return 0;
      }
      revertNum = revertNum * 10 + moreNum;
    }
    return revertNum;

  }

  /**
   * 1221 is palindrome
   */
  public static boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }

    int revertNum = 0;
    while (revertNum < x) {
      revertNum = revertNum * 10 + x % 10;
      x = x / 10;
    }
    return x == revertNum || revertNum / 10 == x;

  }

  @Test
  public void testPalindrome() {
    assertTrue(isPalindrome(1221));
    assertTrue(isPalindrome(222));
    assertFalse(isPalindrome(2221));
  }

  @Test
  public void testReverse() {
    assert reverse(120) == 21;
    assert reverse(123) == 321;
    assert reverse(-120) == -21;
    assert reverse(Integer.MAX_VALUE) == 0;
    assert reverse(Integer.MIN_VALUE) == 0;
  }

}
