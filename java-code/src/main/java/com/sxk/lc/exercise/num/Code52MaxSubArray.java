package com.sxk.lc.exercise.num;

/**
 * @author sxk
 */
public class Code52MaxSubArray {


  public static void main(String[] args) {
    int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(array));
  }

  /**
   * 53. 最大子序和
   * https://leetcode-cn.com/problems/maximum-subarray/
   *
   * @param nums
   * @return
   */
  public static int maxSubArray(int[] nums) {
    int length = nums.length;
    if (length == 1) {
      return nums[0];
    }
    int ans = nums[0];
    int[] maxArray = new int[length];
    maxArray[0] = nums[0];

    for (int i = 1; i < length; i++) {
      if (maxArray[i - 1] > 0) {
        maxArray[i] = nums[i] + maxArray[i - 1];
      } else {
        maxArray[i] = nums[i];
      }
      ans = Math.max(ans, maxArray[i]);
    }
    return ans;
  }


  public int maxSubArray2(int[] nums) {
    int n = nums.length;
    int res = nums[0];
    int[] array = new int[n];
    array[0] = nums[0];
    for (int i = 1; i < n; i++) {
      if (array[i - 1] > 0) {
        array[i] = array[i - 1] + nums[i];
      } else {
        array[i] = nums[i];
      }
      res = Math.max(res, array[i]);
    }
    return res;
  }
}
