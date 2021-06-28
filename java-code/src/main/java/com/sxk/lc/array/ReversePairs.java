package com.sxk.lc.array;

import java.util.Arrays;

/**
 * @author sxk
 */
public class ReversePairs {

  /***
   * 逆序对(归并排序) O(n*log(n))
   * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
   * @param args
   */
  public static void main(String[] args) {
    //int[] arr = new int[]{2, 6, 4, 9, 5};
    int[] arr = new int[]{7, 5, 6, 4};
    System.out.println(Arrays.toString(arr));
    final int num = reversePairs(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(num);

  }

  public static int reversePairs(int[] nums) {
    return reversePairs(nums, 0, nums.length - 1);
  }

  public static int reversePairs(int[] nums, int l, int r) {
    if (l == r) {
      return 0;
    }
    int mid = l + (r - l) / 2;
    final int leftNum = reversePairs(nums, l, mid);
    final int rightNum = reversePairs(nums, mid + 1, r);
    return leftNum + rightNum + merge(nums, l, mid, r);
  }

  public static int merge(int[] nums, int l, int mid, int r) {
    int[] help = new int[r - l + 1];
    int res = 0;
    int i = 0;
    int p1 = l;
    int p2 = mid + 1;
    while (p1 <= mid && p2 <= r) {
      res += nums[p1] > nums[p2] ? (mid - p1 + 1) : 0;
      help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
    }
    while (p1 <= mid) {
      help[i++] = nums[p1++];
    }
    while (p2 <= r) {
      help[i++] = nums[p2++];
    }
    for (int j = 0; j < help.length; j++) {
      nums[l + j] = help[j];
    }
    return res;
  }

}
