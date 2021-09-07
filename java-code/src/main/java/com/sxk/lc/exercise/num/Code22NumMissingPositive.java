package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code22NumMissingPositive {


  public static void main(String[] args) {

    int[] nums = {2, 2};

    //int[] nums = {3, 4, -1, 1, 9, -5};
    //int[] nums = {7, 8, 9, 11, 12};
    System.out.println(firstMissingPositive(nums));
  }

  /**
   * 41. 缺失的第一个正数
   * https://leetcode-cn.com/problems/first-missing-positive/
   *
   * @param nums
   * @return
   */


  public static int firstMissingPositive(int[] nums) {
    int n = nums.length;
    /**
     * 将0和负数都赋值为n+1
     */
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0) {
        nums[i] = n + 1;
      }
    }

    /**
     * 将在1～n出现的数对应的下标0～n-1 赋值为负数（代表出现过）
     */
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num <= n) {
        nums[num - 1] = -Math.abs(nums[num - 1]);
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    /**
     * 如果0～n-1 都出现过，就返回n+1
     */
    return n + 1;
  }

}

