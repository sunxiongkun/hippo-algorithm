package com.sxk.lc.nums;

/**
 * @author sxk
 * @date 2021/4/27 8:48 下午
 */
public class FindMinKth {

  public static void main(String[] args) {
    int[] arr = {1, 8, 3, 5, 7, 9, 4};
    final int index = "aabcd".indexOf("bc");
    System.out.println(minKth2(arr, 2));
  }

  public static int[] copyArray(int[] arr) {
    int[] ans = new int[arr.length];
    for (int i = 0; i != ans.length; i++) {
      ans[i] = arr[i];
    }
    return ans;
  }

  /***
   * // 改写快排，时间复杂度O(N)
   * // k >= 1
   *
   * @param array
   * @param k
   * @return
   */
  public static int minKth2(int[] array, int k) {
    int[] arr = copyArray(array);
    return process2(arr, 0, arr.length - 1, k - 1);
  }

  // arr 第k小的数
  // process2(arr, 0, N-1, k-1)
  // arr[L..R]  范围上，如果排序的话(不是真的去排序)，找位于index的数
  // index [L..R]
  public static int process2(int[] arr, int L, int R, int index) {
    if (L == R) { // L = =R ==INDEX
      return arr[L];
    }
    // 不止一个数  L +  [0, R -L]
    int pivot = arr[L + (int) (Math.random() * (R - L + 1))];
    int[] range = partition(arr, L, R, pivot);
    if (index >= range[0] && index <= range[1]) {
      return arr[index];
    } else if (index < range[0]) {
      return process2(arr, L, range[0] - 1, index);
    } else {
      return process2(arr, range[1] + 1, R, index);
    }
  }

  public static int[] partition(int[] arr, int L, int R, int pivot) {
    int less = L - 1;
    int more = R + 1;
    int cur = L;
    while (cur < more) {
      if (arr[cur] < pivot) {
        swap(arr, ++less, cur++);
      } else if (arr[cur] > pivot) {
        swap(arr, cur, --more);
      } else {
        cur++;
      }
    }
    return new int[]{less + 1, more - 1};
  }

  public static void swap(int[] arr, int i1, int i2) {
    int tmp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = tmp;
  }

}