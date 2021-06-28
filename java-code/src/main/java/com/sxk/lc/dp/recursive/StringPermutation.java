package com.sxk.lc.dp.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 * @date 2021/4/24 10:56 上午
 */
public class StringPermutation {

  public static void main(String[] args) {
    System.out.println(strPermutation("abc"));
  }


  /**
   * 字符串全排列 从左向右尝试，第一个位置到最后一个位置
   *
   * @param str
   * @return
   */
  public static List<String> strPermutation(String str) {
    List<String> ans = new ArrayList<>();
    final char[] arr = str.toCharArray();
    process(arr, 0, ans);
    return ans;
  }

  /***
   * [0...i] 做好选择
   * [i...n-1] 都有机会来到i位置
   * i=n 终止 记录ans
   *
   *
   * @param arr
   * @param i
   * @param ans
   */
  public static void process(char[] arr, int i, List<String> ans) {
    if (i == arr.length) {
      ans.add(String.valueOf(arr));
      return;
    }
    for (int j = i; j < arr.length; j++) {
      swap(arr, i, j);
      process(arr, i + 1, ans);
      swap(arr, i, j);
    }
  }

  public static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
