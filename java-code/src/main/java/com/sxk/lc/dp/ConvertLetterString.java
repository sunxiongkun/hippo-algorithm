package com.sxk.lc.dp;

/**
 * @author sxk
 * @date 2021/4/24 11:16 上午
 */
public class ConvertLetterString {

  public static void main(String[] args) {
    String s = "111239";
    System.out.println(process(s.toCharArray(), 0));
  }

  /***
   *
   * i之前的位置已经尝试
   * i之后的位置有多少种转化结果
   * @param arr
   * @param ans
   * @return
   */
  public static int process(char[] arr, int i) {
    if (i == arr.length) {
      return 1;
    }
    if (arr[i] == '0') {
      return 0;
    }
    if (arr[i] == '1') {
      int res = process(arr, i + 1);
      if (i + 1 < arr.length) {
        res += process(arr, i + 2);
      }
      return res;
    }

    if (arr[i] == '2') {
      int res = process(arr, i + 1);
      if (i + 1 < arr.length && arr[i + 1] >= '0' && arr[i + 1] <= '6') {
        res += process(arr, i + 2);
      }
      return res;
    }

    return process(arr, i + 1);

  }
}
