package com.sxk.lc.bt.top.arr;

/**
 * @author sxk
 */
public class KthArray {

  public static void main(String[] args) {
    int[] nums = {1, 4, 6, 4, 4, 3, 2};
    System.out.println(findKthLargest(nums, 2));

  }

  /**
   * 数组中第k个最大元素
   * <p>
   * 215 -> https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
   *
   * @param nums
   * @param k
   * @return
   */
  public static int findKthLargest(int[] nums, int k) {
    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
  }

  public static int findKthLargest(int[] nums, int l, int r, int index) {
    if (l == r) {
      return nums[l];
    }
    int pivot = nums[l + ((int) (Math.random() * (r - l + 1)))];
    int[] eqAreaNum = partition(nums, l, r, pivot);
    // 不止一个数  L +  [0, R -L]
    if (index >= eqAreaNum[0] && index <= eqAreaNum[1]) {
      return nums[index];
    } else if (index < eqAreaNum[0]) {
      return findKthLargest(nums, l, eqAreaNum[0] - 1, index);
    } else {
      return findKthLargest(nums, eqAreaNum[1] + 1, r, index);
    }
  }

  /**
   * @param nums
   * @return
   */
  public static int[] partition(int[] nums, int l, int r, int pivot) {
    int less = l - 1;
    int more = r + 1;
    int cur = l;
    while (cur < more) {
      if (nums[cur] < pivot) {
        swap(nums, ++less, cur++);
      } else if (nums[cur] > pivot) {
        swap(nums, cur, --more);
      } else {
        cur++;
      }
    }
    return new int[]{less + 1, more - 1};
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
