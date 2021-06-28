package com.sxk.lc.bt.top;

/**
 * @author sxk
 */
public class RainWater {

  public static void main(String[] args) {

  }

  public int trap(int[] height) {
    return process(height, 0, height.length - 1);

  }

  public static int process(int[] height, int l, int r) {
    if (l + 1 >= r) {
      return 0;
    }
    if (l + 2 == r) {

    }


    return 0;
  }


}
