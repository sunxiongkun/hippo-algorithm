package com.sxk.lc.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 */
public class BitTest {


  public static void main(String[] args) {

  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {

    }

    return result;
  }

  /**
   * 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0=a
   * <p>
   * 任何数和其自身做异或运算，结果是 0，即 a ^ a=0。
   * <p>
   * 异或运算满足交换律和结合律，即 a ^ b ^ a= b ^ a ^ b= b ^ (0)= b
   *
   * @param args
   */
  public static void bit() {

  }

  /**
   * https://leetcode-cn.com/problems/single-number/
   *
   * @param nums
   * @return
   */
  public int singleNumber(int[] nums) {
    int single = 0;
    for (int num : nums) {
      single ^= num;
    }
    return single;
  }

  /**
   * https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
   *
   * @param nums
   * @return
   */

  public int singleNumber2(int[] nums) {
    int ans = 0;
    for (int i = 0; i < 32; ++i) {
      int total = 0;
      for (int num : nums) {
        total += ((num >> i) & 1);
      }
      if (total % 3 != 0) {
        ans |= (1 << i);
      }
    }
    return ans;
  }


  /**
   * https://leetcode-cn.com/problems/single-number-iii/
   *
   * @param nums
   * @return
   */
  public int[] singleNumber3(int[] nums) {
    int ret = 0;
    for (int n : nums) {
      ret ^= n;
    }
    int div = 1;
    while ((div & ret) == 0) {
      div <<= 1;
    }
    int a = 0, b = 0;
    for (int n : nums) {
      if ((div & n) != 0) {
        a ^= n;
      } else {
        b ^= n;
      }
    }
    return new int[]{a, b};
  }

}
